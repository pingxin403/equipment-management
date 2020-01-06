package com.hyp.ujs.em.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyp.ujs.em.dto.ServiceTeamDto;
import com.hyp.ujs.em.entity.ServiceTeam;
import com.hyp.ujs.em.service.IServiceTeamService;
import com.hyp.ujs.em.vo.ServiceTeamVo;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * <p>
 * 服务班组 前端控制器
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@RestController
@RequestMapping("/service-team")
@Api(tags = "服务班组")
public class ServiceTeamController {
    @Autowired
    private IServiceTeamService teamService;


    @PostMapping("/")
    public ServiceTeam add(@RequestBody ServiceTeamDto vo) {
        ServiceTeam serviceTeam = new ServiceTeam();
        BeanUtils.copyProperties(vo, serviceTeam);

        if (teamService.save(serviceTeam)) {
            return serviceTeam;
        } else {
            return null;
        }
    }

    @PutMapping("/{id}")
    public ServiceTeam update(@PathVariable("id") Integer id, @RequestBody ServiceTeam vo) {
        ServiceTeam serviceTeam = teamService.getById(id);
        if (Objects.isNull(serviceTeam)) {
            return null;
        }
        BeanUtils.copyProperties(vo, serviceTeam);
        if (teamService.updateById(vo)) {
            return vo;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return teamService.removeById(id);
    }

    @GetMapping("/{id}")
    public ServiceTeam get(@PathVariable("id") Integer id) {
        return teamService.getById(id);
    }

    @GetMapping("/")
    public Page<ServiceTeam> list(ServiceTeamVo vo) {
        ServiceTeam detail = new ServiceTeam();
        BeanUtils.copyProperties(vo, detail);
        Page<ServiceTeam> page = new Page<>((vo.getPn() - 1) * vo.getPs(), vo.getPs());
        return teamService.page(page, Wrappers.query(detail));
    }
}
