package com.tct.data.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 策略ID
     */
    @TableField("strategy_id")
    private Long strategyId;

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
     * 状态，0：已结束（拒绝），1：已结束（成功），2：进行中
     */
    @TableField("status")
    private Integer status;

    /**
     * 描述
     */
    @TableField("desc")
    private String desc;


}
