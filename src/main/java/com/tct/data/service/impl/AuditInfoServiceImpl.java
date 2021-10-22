package com.tct.data.service.impl;

import com.tct.data.model.AuditInfo;
import com.tct.data.dao.AuditInfoMapper;
import com.tct.data.service.AuditInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 审批记录表 服务实现类
 * </p>
 *
 * @author hannibal
 * @since 2021-10-20
 */
@Service
public class AuditInfoServiceImpl extends ServiceImpl<AuditInfoMapper, AuditInfo> implements AuditInfoService {

}
