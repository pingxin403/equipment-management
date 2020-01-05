package com.hyp.ujs.em.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyp.ujs.em.entity.MaintenanceTask;
import com.hyp.ujs.em.service.IMaintenanceTaskService;
import com.hyp.ujs.em.vo.MaintenanceTaskVo;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public MaintenanceTask add(@RequestBody MaintenanceTask vo) {
        if (taskService.save(vo)) {
            return vo;
        } else {
            return null;
        }
    }

    @PutMapping("/")
    public MaintenanceTask update(@RequestBody MaintenanceTask vo) {
        if (taskService.updateById(vo)) {
            return vo;
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
