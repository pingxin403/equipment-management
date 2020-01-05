package com.hyp.ujs.em.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hyp.ujs.em.commons.constant.DeviceTaskStatus;
import com.hyp.ujs.em.commons.constant.DeviceTaskType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 设备维修任务
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_device_task")
public class DeviceTask extends BaseBean {

    private static final long serialVersionUID = 1L;

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
