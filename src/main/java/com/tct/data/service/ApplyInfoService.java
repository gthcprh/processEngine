package com.tct.data.service;

import com.tct.data.model.ApplyInfo;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
