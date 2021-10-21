package com.tct.data.queue;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tct.data.enums.ApproveTypes;
import com.tct.data.enums.RequestTypes;
import com.tct.data.enums.ResultCode;
import com.tct.data.model.*;
import com.tct.data.model.msg.ApplyMessage;
import com.tct.data.model.msg.ApproveMessage;
import com.tct.data.service.ApiInfoService;
import com.tct.data.service.ApplyInfoService;
import com.tct.data.service.ServerInfoService;
import com.tct.data.service.StrategyConfigService;
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
        applyInfo.setApplyInfo(applyMessage.getData());
        applyInfoService.save(applyInfo);
        //包装消息开始流转
        ApproveMessage approveMessage = new ApproveMessage();
        approveMessage.setMsgId(applyInfo.getId());
        approveMessage.setCurrentNode(1);
        approveMessage.setApplyInfo(applyInfo);
        nodeForward(approveMessage, applyMessage.getStrategyId(), 1);
    }

    /**
     * 申请类型节点转发
     *
     * @param message
     * @param strategyId
     * @param currentNode
     */
    public void nodeForward(ApproveMessage message, int strategyId, int currentNode) {
        StrategyConfig strategyConfig = strategyConfigService.getById(strategyId);
        String info = strategyConfig.getStrategyDetail();
        JSONArray jsonArray = JSONArray.parseArray(info);
        StrategyInfo strategyInfo = jsonArray.getObject(currentNode - 1, StrategyInfo.class);
        ApproveTypes approveTypes = ApproveTypes.getEnum(strategyInfo.getType());
        message.setNodeTypeCode(approveTypes.getType());
        message.setNodeTypeName(approveTypes.getName());
        switch (approveTypes) {
            case SIMPLE:
                int apiId = strategyInfo.getTargetServer().get(0);
                ApproverInfo approverInfo = strategyInfo.getInfo().get(0);
                message.setApproverInfo(approverInfo);
                String msg = JSONObject.toJSONString(message);
                informNextNode(apiId, msg);
                break;
            case AND_APPROVE:
            case OR_APPROVE:
                List<ApproverInfo> approverInfos=strategyInfo.getInfo();
                for (int i : strategyInfo.getTargetServer()) {
                    int apiId1 = strategyInfo.getTargetServer().get(i);
                    message.setApproverInfo(approverInfos.get(i));
                    String msg1 = JSONObject.toJSONString(message);
                    informNextNode(apiId1, msg1);
                }
                break;
            default:
                break;
        }
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
        ApproveTypes approveTypes = ApproveTypes.getEnum(strategyInfo.getType());
        String data = "";
        switch (approveTypes) {
            case SIMPLE:
                int apiId = strategyInfo.getTargetServer().get(0);
                Result simpleResult=informNextNode(apiId, data);
                if(simpleResult.getResultCode()==ResultCode.SUCCESS.getCode()){

                }
                break;
            case AND_APPROVE:
            case OR_APPROVE:
                for (int i : strategyInfo.getTargetServer()) {
                    Result approveResult=informNextNode(i, data);
                    if(approveResult.getResultCode()==ResultCode.SUCCESS.getCode()){

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
}
