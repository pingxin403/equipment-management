package com.hyp.ujs.em.commons.constant;

/**
 * @author hyp
 * Project name is spring-boot-learn
 * Include in com.hyp.learn.async.commons
 * hyp create at 19-12-21
 **/
public enum CommonCode implements BaseCodeEnum {


    // ========== 系统级别 ==========
    SUCCESS(0, "成功"),
    SYS_ERROR(2001001000, "服务端发生异常"),
    MISSING_REQUEST_PARAM_ERROR(2001001001, "参数缺失"),

    // ========== 用户模块 ==========
    USER_NOT_FOUND(1001002000, "用户不存在"),

    // ========== 订单模块 ==========

    // ========== 商品模块 ==========
    ;

    /**
     * 错误码
     */
    private int code;
    /**
     * 错误提示
     */
    private String msg;


    CommonCode(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }}
