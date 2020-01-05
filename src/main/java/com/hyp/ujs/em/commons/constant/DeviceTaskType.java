package com.hyp.ujs.em.commons.constant;

/**
 * 设备任务类型
 *
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.commons
 * hyp create at 20-1-4
 **/
public enum DeviceTaskType implements BaseCodeEnum {


    /**
     * 日常保养，由物业进行
     */
    UPKEEP(1, "日常保养"),
    /**
     * 维修，由维修员进行
     */
    MAINTAIN(2, "维修"),
    /**
     * 质检，由维修员进行
     */
    QUALITYTESTING(3, "质检");
    int code;
    String name;

    DeviceTaskType(int code, String name) {
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
