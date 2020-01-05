package com.hyp.ujs.em.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyp.ujs.em.commons.constant.DeviceTaskStatus;
import com.hyp.ujs.em.commons.constant.DeviceTaskType;
import com.hyp.ujs.em.dto.DeviceTaskStatusDto;
import com.hyp.ujs.em.dto.DeviceTaskTypeDto;
import com.hyp.ujs.em.entity.DeviceTask;
import com.hyp.ujs.em.mapper.DeviceTaskMapper;
import com.hyp.ujs.em.service.IDeviceTaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 设备维修任务 服务实现类
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@Service
public class DeviceTaskServiceImpl extends ServiceImpl<DeviceTaskMapper, DeviceTask> implements IDeviceTaskService {

    @Override
    public String makeMsg(DeviceTask task) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n您好，设备信息:")
                .append(task.getDesc())
                .append("。\n状态：")
                .append(task.getStatus().getMsg())
                .append("。\n类型：")
                .append(task.getType().getMsg())
                .append("。\n请及时联系我们。");
        return sb.toString();
    }

    @Override
    public List<DeviceTaskStatusDto> listDeviceTaskStatus() {
        return Stream.of(DeviceTaskStatus.values())
                .map(
                        (item) -> DeviceTaskStatusDto.builder()
                                .name(item.getMsg())
                                .code(item.getCode())
                                .build()

                ).collect(Collectors.toList());
    }

    @Override
    public List<DeviceTaskTypeDto> listDeviceTaskType() {
        return Stream.of(DeviceTaskType.values())
                .map(
                        (item) -> DeviceTaskTypeDto.builder()
                                .name(item.getMsg())
                                .code(item.getCode())
                                .build()

                ).collect(Collectors.toList());
    }
}
