package com.hyp.ujs.em.commons.constant;

/**
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.commons.constant
 * hyp create at 20-1-5
 **/
public enum DeviceDetailStatus implements BaseCodeEnum {


    /**
     * 未完成
     */
    NEW(1, "新增"),
    /**
     * 安装
     */
    INSTALLED(2, "安装"),

    /**
     * 检查
     */
    INSPECTION(3, "检查"),
    /**
     * 维护
     */
    MAINTAIN(4, "维护"),
    /**
     * 过期
     */
    EXPIRED(5, "过期"),
    /**
     * 停用
     */
    DISABLE(6, "停用");
    int code;
    String name;

    DeviceDetailStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }


    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return name;
    }

    public static DeviceDetailStatus from(String s) {
        for (DeviceDetailStatus status : DeviceDetailStatus.values()) {
            if (status.getMsg().equals(s)) {
                return status;
            }
        }
        return null;
    }

}
