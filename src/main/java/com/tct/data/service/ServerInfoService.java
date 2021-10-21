package com.tct.data.service;

import com.tct.data.model.ServerInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务信息 服务类
 * </p>
 *
 * @author hannibal
 * @since 2021-10-18
 */
public interface ServerInfoService extends IService<ServerInfo> {

    ServerInfo getByToken(String token);
}
