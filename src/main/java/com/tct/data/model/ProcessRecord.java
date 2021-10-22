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
 * 流程执行记录
 * </p>
 *
 * @author hannibal
 * @since 2021-10-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("process_record")
public class ProcessRecord implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 申请ID
     */
    @TableField("apply_id")
    private Long applyId;

    /**
     * 当前节点
     */
    @TableField("current_node")
    private Integer currentNode;

    /**
     * 节点描述
     */
    @TableField("node_describe")
    private String nodeDescribe;

    /**
     * 状态（0：未执行，1：执行完毕）
     */
    @TableField("status")
    private Integer status;

    /**
     * 下一节点
     */
    @TableField("next_node")
    private Integer nextNode;

    /**
     * 审批人
     */
    @TableField("aduitr")
    private String aduitr;

    /**
     * 审批意见
     */
    @TableField("aduit_info")
    private String aduitInfo;


}
