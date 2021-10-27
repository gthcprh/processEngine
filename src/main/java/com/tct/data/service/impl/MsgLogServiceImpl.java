package com.tct.data.service.impl;

import com.tct.data.model.MsgLog;
import com.tct.data.dao.MsgLogMapper;
import com.tct.data.service.MsgLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消息日志 服务实现类
 * </p>
 *
 * @author hannibal
 * @since 2021-10-27
 */
@Service
public class MsgLogServiceImpl extends ServiceImpl<MsgLogMapper, MsgLog> implements MsgLogService {

}
