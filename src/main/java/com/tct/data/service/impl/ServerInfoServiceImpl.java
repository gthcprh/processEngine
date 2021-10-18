package com.tct.data.service.impl;

import com.tct.data.model.ServerInfo;
import com.tct.data.dao.ServerInfoMapper;
import com.tct.data.service.ServerInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
