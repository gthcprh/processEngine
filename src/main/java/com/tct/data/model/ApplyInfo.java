package com.tct.data.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 申请信息
 * </p>
 *
 * @author hannibal
 * @since 2021-10-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("apply_info")
public class ApplyInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * source_id
     */
    @TableId(value = "source_id")
    private Long sourceId;

    /**
     * server_id
     */
    @TableId(value = "server_id")
    private Integer serverId;

    /**
     * 策略ID
     */
    @TableField("strategy_id")
    private Integer strategyId;

    /**
     * 申请人
     */
    @TableField("applicant")
    private String applicant;

    /**
     * 申请信息
     */
    @TableField("apply_info")
    private String applyInfo;

    /**
     * 申请凭证
     */
    @TableField("certificate")
    private String certificate;

    /**
     * 当前节点
     */
    @TableField("current_node")
    private Integer currentNode;
    /**
     * 状态，0：已结束（拒绝），1：已结束（成功），2：进行中
     */
    @TableField("status")
    private Integer status;

    /**
     * 用于申请结束，反馈原系统api的id
     */
    @TableField("feedback_api_id")
    private Integer feedbackApiId;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 创建时间
     */
    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

}
