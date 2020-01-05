package com.hyp.ujs.em.vo;

import com.hyp.ujs.em.commons.constant.DeviceTaskStatus;
import com.hyp.ujs.em.commons.constant.DeviceTaskType;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.vo
 * hyp create at 20-1-5
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel
public class DeviceTaskVo extends BaseVo {
    /**
     * 任务类型
     */
    private DeviceTaskType type;

    private DeviceTaskStatus status;

    private Integer dId;

    private Integer fixId;

    private Integer serviceId;

}
