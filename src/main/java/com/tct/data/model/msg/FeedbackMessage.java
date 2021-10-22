package com.tct.data.model.msg;

import com.tct.data.model.ApplyInfo;
import com.tct.data.model.AuditorInfo;
import lombok.Data;

/**
 * @Author: Hannibal
 * @Date: 2021/10/11 18:09
 * @Version 1.0
 * @description 审批消息统一格式
 */
@Data
public class FeedbackMessage {

    /**
     * 全局唯一id
     */
    private Long msgId;

    /**
     * 当前节点
     */
    private Integer currentNode;

    /**
     * 用户请求表示，用于验证原系统
     */
    private String token;

    /**
     * 当前节点
     */
    private String data;

    private Integer apiId;
}
