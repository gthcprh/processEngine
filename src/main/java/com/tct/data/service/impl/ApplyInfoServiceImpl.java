package com.tct.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tct.data.dao.ApplyInfoMapper;
import com.tct.data.model.ApplyInfo;
import com.tct.data.model.AuditInfo;
import com.tct.data.service.ApplyInfoService;
import com.tct.data.service.AuditInfoService;
import com.tct.data.util.Result;
import com.tct.data.util.ResultGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 申请信息 服务实现类
 *
 * @author hannibal
 * @since 2021-10-11
 */
@Service
public class ApplyInfoServiceImpl extends ServiceImpl<ApplyInfoMapper, ApplyInfo> implements ApplyInfoService {

    @Resource
    AuditInfoService auditInfoService;

    @Override
    public boolean updateStatus(Long applyId, int status){
        UpdateWrapper<ApplyInfo> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().set(ApplyInfo::getStatus,status)
                .eq(ApplyInfo::getId,applyId);
        return this.update(updateWrapper);
    }

    @Override
    public boolean updateNode(Long applyId, int nodeNum){
        UpdateWrapper<ApplyInfo> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().set(ApplyInfo::getCurrentNode,nodeNum)
                .eq(ApplyInfo::getId,applyId);
        return this.update(updateWrapper);
    }

    @Override
    public ApplyInfo getByResourceIdAndServerId(Long sourceId, Integer serverId){
        QueryWrapper<ApplyInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(ApplyInfo::getSourceId,sourceId)
                .eq(ApplyInfo::getServerId,serverId);
        return this.getOne(queryWrapper);
    }

    @Override
    public Result progress(Long msgId){
        List<AuditInfo> list=auditInfoService.getByMsgId(msgId);
        return ResultGenerator.success(list);
    }

    @Override
    public ApplyInfo getMsgId(Long applyId, Integer serverId){
        QueryWrapper<ApplyInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(ApplyInfo::getSourceId,applyId)
                .eq(ApplyInfo::getServerId,serverId);
        ApplyInfo applyInfo=this.getOne(queryWrapper);
        return applyInfo;
    }
}
