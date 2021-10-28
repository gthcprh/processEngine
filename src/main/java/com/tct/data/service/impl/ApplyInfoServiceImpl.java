package com.tct.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tct.data.dao.ApplyInfoMapper;
import com.tct.data.model.ApplyInfo;
import com.tct.data.service.ApplyInfoService;
import org.springframework.stereotype.Service;

/**
 * 申请信息 服务实现类
 *
 * @author hannibal
 * @since 2021-10-11
 */
@Service
public class ApplyInfoServiceImpl extends ServiceImpl<ApplyInfoMapper, ApplyInfo> implements ApplyInfoService {

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
}
