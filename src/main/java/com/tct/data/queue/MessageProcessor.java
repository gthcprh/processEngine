package com.tct.data.queue;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tct.data.enums.AuditTypes;
import com.tct.data.enums.RequestTypes;
import com.tct.data.enums.ResultCode;
import com.tct.data.model.*;
import com.tct.data.model.msg.ApplyMessage;
import com.tct.data.model.msg.AuditMessage;
import com.tct.data.model.msg.FeedbackMessage;
import com.tct.data.service.*;
import com.tct.data.util.HttpClientUtils;
import com.tct.data.util.Result;
import com.tct.data.util.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Hannibal
 * @Date: 2021/10/11 18:26
 * @Version 1.0
 * @description
 */
@Slf4j
@Component
public class MessageProcessor {

    @Resource
    StrategyConfigService strategyConfigService;

    @Resource
    ApplyInfoService applyInfoService;

    @Resource
    ServerInfoService serverInfoService;

    @Resource
    ApiInfoService apiInfoService;

    @Resource
    AuditInfoService auditInfoService;

    /**
     * 处理申请队列消息
     *
     * @param applyMessage
     */
    public void dealApply(ApplyMessage applyMessage) {
        log.info(applyMessage.getData());
        ApplyInfo applyInfo = applyMessage.toApplyInfo();
        ServerInfo serverInfo = serverInfoService.getByToken(applyMessage.getToken());
        if (ObjectUtils.isEmpty(serverInfo)) {
            return;
        }
        applyInfo.setServerId(serverInfo.getId());
        applyInfo.setStatus(2);
        applyInfo.setCurrentNode(0);
        applyInfo.setApplyInfo(applyMessage.getData());
        applyInfoService.save(applyInfo);
        //包装消息开始流转
        AuditMessage aduitMessage = new AuditMessage();
        aduitMessage.setMsgId(applyInfo.getId());
        aduitMessage.setCurrentNode(1);
        aduitMessage.setApplyInfo(applyInfo);
        nodeForward(aduitMessage, applyMessage.getStrategyId(), 1);
    }

    /**
     * 申请类型节点转发
     *
     * @param message
     * @param strategyId
     * @param currentNode
     */
    public void nodeForward(AuditMessage message, int strategyId, int currentNode) {
        StrategyConfig strategyConfig = strategyConfigService.getById(strategyId);
        String info = strategyConfig.getStrategyDetail();
        JSONArray jsonArray = JSONArray.parseArray(info);
        StrategyInfo strategyInfo = jsonArray.getObject(currentNode - 1, StrategyInfo.class);
        AuditTypes auditTypes = AuditTypes.getEnum(strategyInfo.getType());
        message.setNodeTypeCode(auditTypes.getType());
        message.setNodeTypeName(auditTypes.getName());
        message.setCurrentNode(currentNode);
        switch (auditTypes) {
            case SIMPLE:
                int apiId = strategyInfo.getTargetServer().get(0);
                AuditorInfo auditorInfo = strategyInfo.getInfo().get(0);

                AuditInfo auditInfo = new AuditInfo();
                auditInfo.setAuditorId(auditorInfo.getAuditorId());
                auditInfo.setAuditRoleId(auditorInfo.getAuditRoleId());
                auditInfo.setApplyId(message.getMsgId());
                auditInfo.setCurrentNode(currentNode);
                auditInfo.setApiId(apiId);
                auditInfo.setStatus(2);
                auditInfoService.save(auditInfo);

                message.setAuditId(auditInfo.getId());
                message.setAuditorInfo(auditorInfo);
                String msg = JSONObject.toJSONString(message);
                informNextNode(apiId, msg);
                break;
            case AND_APPROVE:
            case OR_APPROVE:
                List<AuditorInfo> auditorInfos = strategyInfo.getInfo();
                for (int i : strategyInfo.getTargetServer()) {
                    int apiId1 = strategyInfo.getTargetServer().get(i);
                    AuditorInfo auditorInfo1 = auditorInfos.get(i);

                    AuditInfo auditInfo1 = new AuditInfo();
                    auditInfo1.setAuditorId(auditorInfo1.getAuditorId());
                    auditInfo1.setAuditRoleId(auditorInfo1.getAuditRoleId());
                    auditInfo1.setApplyId(message.getMsgId());
                    auditInfo1.setCurrentNode(currentNode);
                    auditInfo1.setApiId(apiId1);
                    auditInfo1.setStatus(2);
                    auditInfoService.save(auditInfo1);

                    message.setAuditId(auditInfo1.getId());
                    message.setAuditorInfo(auditorInfo1);
                    String msg1 = JSONObject.toJSONString(message);
                    informNextNode(apiId1, msg1);
                }
                break;
            default:
                break;
        }
        //结束更新
        applyInfoService.updateNode(message.getMsgId(), message.getCurrentNode());
    }

    /**
     * 节点转发
     *
     * @param message
     * @param strategyId
     * @param currentNode
     */
    public void nodeForward(String message, int strategyId, int currentNode) {
        StrategyConfig strategyConfig = strategyConfigService.getById(strategyId);
        String info = strategyConfig.getStrategyDetail();
        JSONArray jsonArray = JSONArray.parseArray(info);
        StrategyInfo strategyInfo = jsonArray.getObject(currentNode, StrategyInfo.class);
        AuditTypes auditTypes = AuditTypes.getEnum(strategyInfo.getType());
        String data = "";
        switch (auditTypes) {
            case SIMPLE:
                int apiId = strategyInfo.getTargetServer().get(0);
                Result simpleResult = informNextNode(apiId, data);
                if (simpleResult.getResultCode() == ResultCode.SUCCESS.getCode()) {

                }
                break;
            case AND_APPROVE:
            case OR_APPROVE:
                for (int i : strategyInfo.getTargetServer()) {
                    Result aduitResult = informNextNode(i, data);
                    if (aduitResult.getResultCode() == ResultCode.SUCCESS.getCode()) {

                    }
                }
                break;
            default:
                break;
        }
    }

    /**
     * 通知其他节点服务
     *
     * @param apiId
     * @param data
     * @return
     */
    public Result informNextNode(int apiId, String data) {
        ApiInfo apiInfo = apiInfoService.getById(apiId);
        RequestTypes requestTypes = RequestTypes.valueOf(apiInfo.getRequestType());
        switch (requestTypes) {
            case POST:
                Result postResult = HttpClientUtils.doPost(apiInfo.getRequestAddr(), null, data);
                return postResult;
            case GET:
                Result getResult = HttpClientUtils.doGet(apiInfo.getRequestAddr(), null);
                return getResult;
            default:
                return ResultGenerator.fail("不支持的请求类型");
        }
    }

    /**
     * 处理审批反馈消息
     * 单一流程直接通知下一节点，会签或签等待其他流程反馈
     *
     * @param feedbackMessage
     */
    public void dealAuditFeedback(FeedbackMessage feedbackMessage) {
        //校验当前节点与申请节点是否一致，审批id和节点是否匹配，审批状态是否已经批过
        int status = feedbackMessage.getAuditResult();
        ApplyInfo applyInfo = applyInfoService.getById(feedbackMessage.getMsgId());
        if (ObjectUtils.isEmpty(applyInfo)) {
            log.error("申请id不存在");
            return;
        }
        if (!applyInfo.getCurrentNode().equals(feedbackMessage.getCurrentNode())) {
            log.error("审批消息节点与当前进度节点不一致");
            return;
        }
        AuditInfo auditInfo = auditInfoService.getById(feedbackMessage.getAuditId());
        if (!ObjectUtils.isEmpty(auditInfo) && auditInfo.getStatus() != 2) {
            log.error("未找到改审批信息或者该审批已经被处理");
            return;
        }
        boolean result = auditInfoService.updateAuditInfo(feedbackMessage.getAuditId(), status, feedbackMessage.getAuditInfo());
        if (!result) {
            log.error("审批信息修改失败");
            return;
        }
        //判断下一步操作
        StrategyInfo strategyInfo = strategyConfigService.getStrategyInfo(applyInfo.getStrategyId(), applyInfo.getCurrentNode());
        //能否继续流转
        boolean strategyInfoStatus = strategyInfo.isStatus();
        AuditTypes auditTypes = AuditTypes.getEnum(strategyInfo.getType());
        switch (auditTypes) {
            case SIMPLE:
                if (status == 1) {
                    //todo 开始下一节点
                    doNextNode(applyInfo, strategyInfoStatus);
                } else {
                    //todo 失败，流程结束
                    applyInfoService.updateStatus(applyInfo.getId(), 0);
                }
                break;
            case AND_APPROVE:
                if (status == 0) {
                    //todo 失败，流程结束
                    applyInfoService.updateStatus(applyInfo.getId(), 0);
                    return;
                }
                List<Integer> andList = auditInfoService.getOtherAuditStatus(applyInfo.getId(), applyInfo.getCurrentNode());
                if (!andList.contains(2)) {
                    //todo 开始下一节点
                    doNextNode(applyInfo, strategyInfoStatus);
                    return;
                }
                break;
            case OR_APPROVE:
                if (status == 1) {
                    //todo 开始下一流程
                    doNextNode(applyInfo, strategyInfoStatus);
                    return;
                }
                List<Integer> orList = auditInfoService.getOtherAuditStatus(applyInfo.getId(), applyInfo.getCurrentNode());
                if (!orList.contains(2)) {
                    //todo 流程结束，失败
                    applyInfoService.updateStatus(applyInfo.getId(), 0);
                    return;
                }
                break;
            default:
                break;
        }
    }

    /**
     * 下一节点处理
     *
     * @param applyInfo
     * @param strategyInfoStatus
     */
    public void doNextNode(ApplyInfo applyInfo, boolean strategyInfoStatus) {

        if (!strategyInfoStatus) {
            applyInfoService.updateStatus(applyInfo.getId(), 1);
            return;
        }
        int nextNode = applyInfo.getCurrentNode() + 1;
        //包装消息开始流转
        AuditMessage auditMessage = new AuditMessage();
        auditMessage.setMsgId(applyInfo.getId());
        auditMessage.setCurrentNode(nextNode);
        auditMessage.setApplyInfo(applyInfo);
        nodeForward(auditMessage, applyInfo.getStrategyId(), nextNode);
    }

}
