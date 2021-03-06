package com.tct.data.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 服务信息
 * </p>
 *
 * @author hannibal
 * @since 2021-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("api_info")
public class ApiInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    @TableField("api_name")
    private String apiName;

    /**
     * 请求类型
     */
    @TableField("request_type")
    private String requestType;

    /**
     * 所属服务
     */
    @TableField("service_id")
    private Integer serviceId;

    /**
     * 类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 请求地址
     */
    @TableField("request_addr")
    private String requestAddr;

    /**
     * 服务描述
     */
    @TableField("description")
    private String description;


}
