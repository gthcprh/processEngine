package com.tct.data.service.impl;

import com.tct.data.model.ApiInfo;
import com.tct.data.dao.ApiInfoMapper;
import com.tct.data.service.ApiInfoService;
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
public class ApiInfoServiceImpl extends ServiceImpl<ApiInfoMapper, ApiInfo> implements ApiInfoService {

}
