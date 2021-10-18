package com.tct.data.service.impl;

import com.tct.data.model.ProcessRecord;
import com.tct.data.dao.ProcessRecordMapper;
import com.tct.data.service.ProcessRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 流程执行记录 服务实现类
 * </p>
 *
 * @author hannibal
 * @since 2021-10-11
 */
@Service
public class ProcessRecordServiceImpl extends ServiceImpl<ProcessRecordMapper, ProcessRecord> implements ProcessRecordService {

}
