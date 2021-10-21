package com.tct.data.dao;

import com.tct.data.model.ProcessRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 流程执行记录 Mapper 接口
 * </p>
 *
 * @author hannibal
 * @since 2021-10-11
 */
@Mapper
public interface ProcessRecordMapper extends BaseMapper<ProcessRecord> {

}
