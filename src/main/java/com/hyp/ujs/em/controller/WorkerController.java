package com.hyp.ujs.em.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyp.ujs.em.entity.Worker;
import com.hyp.ujs.em.service.IWorkerService;
import com.hyp.ujs.em.vo.WorkerVo;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Worker add(@RequestBody Worker vo) {
        if (workerService.save(vo)) {
            return vo;
        } else {
            return null;
        }
    }

    @PutMapping("/")
    public Worker update(@RequestBody Worker vo) {
        if (workerService.updateById(vo)) {
            return vo;
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
