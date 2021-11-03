package com.tct.data.service;

import com.tct.data.model.AuditInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 审批记录表 服务类
 * </p>
 *
 * @author hannibal
 * @since 2021-10-20
 */
public interface AuditInfoService extends IService<AuditInfo> {

    /**
     * 修改审批信息
     * @param auditId 审批id
     * @param status 审批结果
     * @param auditInfo 审批信息
     * @return
     */
    boolean updateAuditInfo(Long auditId, Integer status, String auditInfo);

    /**
     * 获取同一个申请id下同节点其他审批情况
     * @param applyId
     * @param node
     * @return
     */
    List<AuditInfo> getOtherAuditInfo(Long applyId, int node);

    List<Integer> getOtherAuditStatus(Long applyId, int node);

    List<AuditInfo> getByMsgId(Long msgId);
}
