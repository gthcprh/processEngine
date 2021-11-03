package com.tct.data.service;

import com.tct.data.model.ApplyInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tct.data.util.Result;

/**
 * <p>
 * 申请信息 服务类
 * </p>
 *
 * @author hannibal
 * @since 2021-10-11
 */
public interface ApplyInfoService extends IService<ApplyInfo> {

    boolean updateStatus(Long applyId, int status);

    boolean updateNode(Long applyId, int nodeNum);

    ApplyInfo getByResourceIdAndServerId(Long sourceId, Integer serverId);

    Result progress(Long msgId);

    ApplyInfo getMsgId(Long applyId, Integer serverId);
}
