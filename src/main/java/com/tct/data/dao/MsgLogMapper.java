package com.tct.data.dao;

import com.tct.data.model.MsgLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 消息日志 Mapper 接口
 * </p>
 *
 * @author hannibal
 * @since 2021-10-27
 */
@Mapper
public interface MsgLogMapper extends BaseMapper<MsgLog> {

}
