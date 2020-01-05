package com.hyp.ujs.em.service;

import com.hyp.ujs.em.commons.constant.DeviceTaskStatus;
import com.hyp.ujs.em.commons.constant.DeviceTaskType;
import com.hyp.ujs.em.dto.DeviceTaskStatusDto;
import com.hyp.ujs.em.dto.DeviceTaskTypeDto;
import com.hyp.ujs.em.entity.DeviceTask;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 设备维修任务 服务类
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
public interface IDeviceTaskService extends IService<DeviceTask> {

    /**
     * 根据task创建信息
     * @param task
     * @return
     */
    public String makeMsg(DeviceTask task);

    List<DeviceTaskStatusDto> listDeviceTaskStatus();

    List<DeviceTaskTypeDto> listDeviceTaskType();
}
