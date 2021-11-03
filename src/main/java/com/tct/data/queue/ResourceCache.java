package com.tct.data.queue;

import com.tct.data.model.ServerInfo;
import com.tct.data.service.ServerInfoService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Hannibal
 * @Date: 2021/11/3 10:33
 * @Version 1.0
 * @description
 */
@Component
public class ResourceCache {

    /**系统信息缓存**/
    private static Map<String, ServerInfo> serverInfoMap=new HashMap<>(16);

    @Resource
    ServerInfoService serverInfoService;

    @PostConstruct
    public void init(){
        List<ServerInfo>  list=serverInfoService.list();
        list.forEach(serverInfo -> {
            serverInfoMap.put(serverInfo.getToken(),serverInfo);
        });
    }

    public static Map<String, ServerInfo> serverInfos(){
        return serverInfoMap;
    }
}
