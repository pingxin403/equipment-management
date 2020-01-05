package com.hyp.ujs.em.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyp.ujs.em.entity.DeviceGroup;
import com.hyp.ujs.em.service.IDeviceGroupService;
import com.hyp.ujs.em.vo.DeviceGroupVo;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 设备组 前端控制器
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@RestController
@RequestMapping("/device-group")
@Api(tags = "设备组")
public class DeviceGroupController {
    @Autowired
    private IDeviceGroupService groupService;


    @PostMapping("/")
    public DeviceGroup add(@RequestBody DeviceGroup vo) {
        if (groupService.save(vo)) {
            return vo;
        } else {
            return null;
        }
    }

    @PutMapping("/")
    public DeviceGroup update(@RequestBody DeviceGroup vo) {
        if (groupService.updateById(vo)) {
            return vo;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return groupService.removeById(id);
    }

    @GetMapping("/{id}")
    public DeviceGroup get(@PathVariable("id") Integer id) {
        return groupService.getById(id);
    }

    @GetMapping("/")
    public Page<DeviceGroup> list(DeviceGroupVo vo) {
        DeviceGroup detail = new DeviceGroup();
        BeanUtils.copyProperties(vo, detail);
        Page<DeviceGroup> page = new Page<>((vo.getPn() - 1) * vo.getPs(), vo.getPs());
        return groupService.page(page, Wrappers.query(detail));
    }
}
