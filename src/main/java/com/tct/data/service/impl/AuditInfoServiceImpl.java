package com.tct.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tct.data.dao.AuditInfoMapper;
import com.tct.data.model.AuditInfo;
import com.tct.data.service.AuditInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public boolean updateAuditInfo(Long auditId, Integer status, String auditInfo) {
        UpdateWrapper<AuditInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(AuditInfo::getId, auditId)
                .set(AuditInfo::getStatus, status)
                .set(AuditInfo::getAuditInfo, auditInfo);
        return this.update(updateWrapper);
    }

    @Override
    public List<AuditInfo> getOtherAuditInfo(Long applyId, int node) {
        QueryWrapper<AuditInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(AuditInfo::getApplyId, applyId)
                .eq(AuditInfo::getCurrentNode, node);
        return this.list(queryWrapper);
    }

    @Override
    public List<Integer> getOtherAuditStatus(Long applyId, int node) {
        QueryWrapper<AuditInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select(AuditInfo::getStatus)
                .eq(AuditInfo::getApplyId, applyId)
                .eq(AuditInfo::getCurrentNode, node);
        List<AuditInfo> auditInfos=this.list(queryWrapper);
        if(CollectionUtils.isEmpty(auditInfos)){
            return null;
        }
        List<Integer> list= auditInfos.stream().map(a->a.getStatus()).collect(Collectors.toList());
        return list;
    }
}
