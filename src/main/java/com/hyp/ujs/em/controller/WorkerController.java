package com.hyp.ujs.em.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyp.ujs.em.dto.WorkerDto;
import com.hyp.ujs.em.entity.Worker;
import com.hyp.ujs.em.service.IWorkerService;
import com.hyp.ujs.em.vo.WorkerVo;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * <p>
 * 员工 前端控制器
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@RestController
@RequestMapping("/worker")
@Api(tags = "员工")
public class WorkerController {

    @Autowired
    private IWorkerService workerService;


    @PostMapping("/")
    public Worker add(@RequestBody WorkerDto vo) {
        Worker worker = new Worker();
        BeanUtils.copyProperties(vo, worker);
        if (workerService.save(worker)) {
            return worker;
        } else {
            return null;
        }
    }

    @PutMapping("/{id}")
    public Worker update(@PathVariable("id") Integer id, @RequestBody WorkerDto vo) {
        Worker worker = workerService.getById(id);
        if (Objects.isNull(worker)) {
            return null;
        }
        BeanUtils.copyProperties(vo, worker);
        if (workerService.updateById(worker)) {
            return worker;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return workerService.removeById(id);
    }

    @GetMapping("/{id}")
    public Worker get(@PathVariable("id") Integer id) {
        return workerService.getById(id);
    }

    @GetMapping("/")
    public Page<Worker> list(WorkerVo vo) {
        Worker detail = new Worker();
        BeanUtils.copyProperties(vo, detail);
        Page<Worker> page = new Page<>((vo.getPn() - 1) * vo.getPs(), vo.getPs());
        return workerService.page(page, Wrappers.query(detail));
    }


}
