package com.hyp.ujs.em.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyp.ujs.em.entity.DeviceClass;
import com.hyp.ujs.em.service.IDeviceClassService;
import com.hyp.ujs.em.vo.DeviceAddressVo;
import com.hyp.ujs.em.vo.DeviceClassVo;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 设备类 前端控制器
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@RestController
@RequestMapping("/device-class")
@Api(tags = "设备类")
public class DeviceClassController {

    @Autowired
    private IDeviceClassService classService;


    @PostMapping("/")
    public DeviceClass add(@RequestBody DeviceClass vo) {
        if (classService.save(vo)) {
            return vo;
        } else {
            return null;
        }
    }

    @PutMapping("/")
    public DeviceClass update(@RequestBody DeviceClass vo) {
        if (classService.updateById(vo)) {
            return vo;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return classService.removeById(id);
    }

    @GetMapping("/{id}")
    public DeviceClass get(@PathVariable("id") Integer id) {
        return classService.getById(id);
    }

    @GetMapping("/")
    public Page<DeviceClass> list( DeviceClassVo vo) {
        DeviceClass detail = new DeviceClass();
        BeanUtils.copyProperties(vo, detail);
        Page<DeviceClass> page = new Page<>((vo.getPn() - 1) * vo.getPs(), vo.getPs());
        return classService.page(page, Wrappers.query(detail));
    }
}
