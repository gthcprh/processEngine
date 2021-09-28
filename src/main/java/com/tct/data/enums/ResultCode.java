package com.tct.data.enums;

/**
 * @Author: Hannibal
 * @Date: 2021/7/7 11:19
 * @Version 1.0
 * @description 返回结果枚举
 */
public enum ResultCode {

    SUCCESS(200, "成功"),
    FAIL(500, "失败"),

    /**
     * 系统错误
     */
    SYSTEM_ERROR(999, "系统错误"),

    PARAM_EMPTY(50001,"参数缺失"),
    PARAM_ERROR(50002,"参数错误"),

    TAGS_HAS_EXIST(50101,"标签已存在"),
    TAGS_NOT_EXIST(50102,"标签不存在"),
    TAGS_HAS_RELATED(50103,"该标签已被资产关联"),

    TOPIC_HAS_RELATED(50201, "该主题目录已关联资产"),
    TOPIC_HAS_CHILD(50202, "该主题目录包含子目录"),
    CATALOGUE_NOT_EXIST(50203,"目录不存在"),

    ASSETS_SAVE_FAIL(50401,"资产保存失败"),
    ASSETS_EDIT_FAIL(50401,"资产编辑失败"),
    ASSETS_DISASSOCIATE_FAIL(50403,"资产解挂失败"),
    ASSETS_REASSOCIATE_FAIL(50404,"资产重新挂载失败"),
    ASSETS_ASSOCIATE_FAIL(50405,"资产挂载失败"),
    ASSETS_UNKNOWN_ASSOCIATE_TYPE(50406,"未知挂载类型"),
    ASSETS_NOT_ASSOCIATE(50407,"资产未挂载"),
    ASSETS_NOT_HISTORY_ASSOCIATE(50408,"不是资产历史挂载的记录"),
    ASSETS_REGISTER_FAIL(50409,"资产注册失败"),
    ASSETS_NUM_REPEATED(50410,"资产编号或者名称已存在"),
    ASSETS_NAME_REPEATED(50415,"资产名称已存在"),
    ASSETS_NOT_EXIST(50415,"资产不存在"),
    ASSETS_ONLINE_FAIL(50420,"资产上线失败"),
    ASSETS_OFFLINE_FAIL(50425,"资产下线失败"),
    ASSETS_DELETE_FAIL(50430,"资产删除失败"),
    ASSETS_COPY_FAIL(50431,"资产复制失败"),
    ASSETS_MOVE_FAIL(50432,"资产移动失败"),
    INTERFACE_REQUEST_FAIL(50435,"接口请求失败"),
    INTERFACE_HAS_EXCEPTION(50440,"目标接口异常"),
    ASSETS_NOT_OPERATE(50441,"不具备该操作条件"),
    FAIL_DELETE_STATUS_ONLINE(50442,"资产为发布状态,不能被删除"),

    ASSET_CATALOGUE_TREE_HAS_ASSET(50501,"资产目录树下存在资产,删除失败"),


    END(99999,"");
    private final Integer code;

    private final String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
