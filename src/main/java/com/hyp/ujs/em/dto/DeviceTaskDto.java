package com.hyp.ujs.em.dto;

import com.hyp.ujs.em.commons.constant.DeviceTaskStatus;
import com.hyp.ujs.em.commons.constant.DeviceTaskType;
import lombok.Data;

/**
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.dto
 * hyp create at 20-1-6
 **/
@Data
public class DeviceTaskDto {
    private String name;

    private String desc;

    /**
     * 任务类型
     */
    private DeviceTaskType type;

    private DeviceTaskStatus status;

    private Integer dId;

    private Integer fixId;

    private String fixName;

    private Integer serviceId;

    private String serviceName;
}
