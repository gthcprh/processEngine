package com.tct.data.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 消息日志
 * </p>
 *
 * @author hannibal
 * @since 2021-10-27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("msg_log")
public class MsgLog implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * token
     */
    @TableField("token")
    private String token;

    /**
     * api_id
     */
    @TableField("api_id")
    private Integer apiId;

    /**
     * 所有者
     */
    @TableField("owner")
    private String owner;

    /**
     * 类型，1：申请，2：审批
     */
    @TableField("type")
    private Integer type;

    /**
     * 消息体
     */
    @TableField("data")
    private String data;

    /**
     * 状态
     */
    @TableField("status")
    private Integer status=0;

    /**
     * 原因
     */
    @TableField("description")
    private String description;


}
