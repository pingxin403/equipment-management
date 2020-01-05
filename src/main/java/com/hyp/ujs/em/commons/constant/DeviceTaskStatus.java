package com.hyp.ujs.em.commons.constant;

/**
 * 设备任务状态
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.commons
 * hyp create at 20-1-4
 **/
public enum DeviceTaskStatus implements BaseCodeEnum {


    /**
     * 未完成
     */
    NEW(1, "未完成"),
    /**
     * 完成
     */
    COMPLETED(2, "完成"),
    /**
     * 结束
     */
    FINISH(3, "结束");
    int code;
    String name;

    DeviceTaskStatus(int code, String name) {
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


}
