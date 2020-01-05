package com.hyp.ujs.em.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyp.ujs.em.commons.constant.DeviceTaskStatus;
import com.hyp.ujs.em.dto.DeviceTaskStatusDto;
import com.hyp.ujs.em.dto.DeviceTaskTypeDto;
import com.hyp.ujs.em.entity.DeviceTask;
import com.hyp.ujs.em.service.IDeviceTaskService;
import com.hyp.ujs.em.service.IWorkerService;
import com.hyp.ujs.em.vo.DeviceTaskVo;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO 后续使用消息中间件替代
 * <p>
 * 设备维修任务 前端控制器
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@RestController
@RequestMapping("/device-task")
@Api(tags = "设备维修任务")
public class DeviceTaskController {
    @Autowired
    private IDeviceTaskService taskService;

    @Autowired
    private IWorkerService workerService;


    /**
     * @param vo
     * @return
     */
    @PostMapping("/")
    public DeviceTask add(@RequestBody DeviceTask vo) {
        if (taskService.save(vo)) {
            String msg = taskService.makeMsg(vo);
            workerService.sendMsg(vo.getServiceId(), msg);
            return vo;
        } else {
            return null;
        }
    }

    @PutMapping("/")
    public DeviceTask update(@RequestBody DeviceTask vo) {
        if (taskService.updateById(vo)) {
            String msg = taskService.makeMsg(vo);
            workerService.sendMsg(vo.getServiceId(), msg);
            return vo;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        DeviceTask task = taskService.getById(id);
        boolean res = taskService.removeById(id);
        if (res) {
            String msg = taskService.makeMsg(task);
            task.setStatus(DeviceTaskStatus.FINISH);
            workerService.sendMsg(task.getServiceId(), msg);
        }
        return res;
    }

    @GetMapping("/{id}")
    public DeviceTask get(@PathVariable("id") Integer id) {
        return taskService.getById(id);
    }

    @GetMapping("/")
    public Page<DeviceTask> list(DeviceTaskVo vo) {
        DeviceTask detail = new DeviceTask();
        BeanUtils.copyProperties(vo, detail);
        Page<DeviceTask> page = new Page<>((vo.getPn() - 1) * vo.getPs(), vo.getPs());
        return taskService.page(page, Wrappers.query(detail));
    }

    @GetMapping("/status")
    public List<DeviceTaskStatusDto> listDeviceTaskStatus() {
        return taskService.listDeviceTaskStatus();
    }

    @GetMapping("/types")
    public List<DeviceTaskTypeDto> listDeviceTaskType() {
        return taskService.listDeviceTaskType();
    }
}
