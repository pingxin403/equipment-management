package com.hyp.ujs.em.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyp.ujs.em.dto.MaintenanceScheduleDto;
import com.hyp.ujs.em.entity.MaintenanceSchedule;
import com.hyp.ujs.em.service.IMaintenanceScheduleService;
import com.hyp.ujs.em.vo.MaintenanceScheduleVo;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * <p>
 * 检查计划 前端控制器
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@RestController
@RequestMapping("/maintenance-schedule")
@Api(tags = "检查计划")
public class MaintenanceScheduleController {
    @Autowired
    private IMaintenanceScheduleService scheduleService;


    @PostMapping("/")
    public MaintenanceSchedule add(@RequestBody MaintenanceScheduleDto vo) {
        MaintenanceSchedule schedule = new MaintenanceSchedule();
        BeanUtils.copyProperties(vo, schedule);
        if (scheduleService.save(schedule)) {
            return schedule;
        } else {
            return null;
        }
    }

    @PutMapping("/{id}")
    public MaintenanceSchedule update(@PathVariable("id") Integer id, @RequestBody MaintenanceScheduleDto vo) {
        MaintenanceSchedule schedule = scheduleService.getById(id);
        if (Objects.isNull(schedule)) {
            return null;
        }
        BeanUtils.copyProperties(vo, schedule);
        if (scheduleService.updateById(schedule)) {
            return schedule;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return scheduleService.removeById(id);
    }

    @GetMapping("/{id}")
    public MaintenanceSchedule get(@PathVariable("id") Integer id) {
        return scheduleService.getById(id);
    }

    @GetMapping("/")
    public Page<MaintenanceSchedule> list(MaintenanceScheduleVo vo) {
        MaintenanceSchedule detail = new MaintenanceSchedule();
        BeanUtils.copyProperties(vo, detail);
        Page<MaintenanceSchedule> page = new Page<>((vo.getPn() - 1) * vo.getPs(), vo.getPs());
        return scheduleService.page(page, Wrappers.query(detail));
    }
}
