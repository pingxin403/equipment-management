package com.hyp.ujs.em.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyp.ujs.em.dto.MaintenanceTaskDto;
import com.hyp.ujs.em.entity.MaintenanceTask;
import com.hyp.ujs.em.service.IMaintenanceTaskService;
import com.hyp.ujs.em.vo.MaintenanceTaskVo;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * <p>
 * 保养任务 前端控制器
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@RestController
@RequestMapping("/maintenance-task")
@Api(tags = "保养任务")
public class MaintenanceTaskController {
    @Autowired
    private IMaintenanceTaskService taskService;


    @PostMapping("/")
    public MaintenanceTask add(@RequestBody MaintenanceTaskDto vo) {
        MaintenanceTask task = new MaintenanceTask();
        BeanUtils.copyProperties(vo, task);

        if (taskService.save(task)) {
            return task;
        } else {
            return null;
        }
    }

    @PutMapping("/{id}")
    public MaintenanceTask update(@PathVariable("id") Integer id, @RequestBody MaintenanceTaskDto vo) {
        MaintenanceTask task = taskService.getById(id);
        if (Objects.isNull(task)) {
            return null;
        }
        BeanUtils.copyProperties(vo, task);

        if (taskService.updateById(task)) {
            return task;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return taskService.removeById(id);
    }

    @GetMapping("/{id}")
    public MaintenanceTask get(@PathVariable("id") Integer id) {
        return taskService.getById(id);
    }

    @GetMapping("/")
    public Page<MaintenanceTask> list(MaintenanceTaskVo vo) {
        MaintenanceTask detail = new MaintenanceTask();
        BeanUtils.copyProperties(vo, detail);
        Page<MaintenanceTask> page = new Page<>((vo.getPn() - 1) * vo.getPs(), vo.getPs());
        return taskService.page(page, Wrappers.query(detail));
    }
}
