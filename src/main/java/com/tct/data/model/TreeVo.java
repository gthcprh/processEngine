package com.tct.data.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author: Hannibal
 * @Date: 2021/7/19 16:05
 * @Version 1.0
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeVo {

    private int id;

    private String name;

    private int parentId;

    private Integer type;

    private List<Integer> parentIds;

    private int value;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<TreeVo> children;
}
