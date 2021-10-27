package com.tct.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tct.data.model.ServerInfo;
import com.tct.data.dao.ServerInfoMapper;
import com.tct.data.service.ServerInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 服务信息 服务实现类
 * </p>
 *
 * @author hannibal
 * @since 2021-10-18
 */
@Service
public class ServerInfoServiceImpl extends ServiceImpl<ServerInfoMapper, ServerInfo> implements ServerInfoService {

    @Override
    public ServerInfo getByToken(String token){
        QueryWrapper<ServerInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(ServerInfo::getToken,token);
        return this.getOne(queryWrapper);
    }

    @Override
    public boolean isRepeat(String serverName, String owner){
        QueryWrapper<ServerInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(ServerInfo::getServerName,serverName)
                .eq(ServerInfo::getOwner,owner);
        return !ObjectUtils.isEmpty(this.getOne(queryWrapper));
    }
}
