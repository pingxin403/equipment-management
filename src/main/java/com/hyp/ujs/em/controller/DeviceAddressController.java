package com.hyp.ujs.em.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyp.ujs.em.entity.DeviceAddress;
import com.hyp.ujs.em.service.IDeviceAddressService;
import com.hyp.ujs.em.vo.DeviceAddressVo;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 安装位置 前端控制器
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@RestController
@RequestMapping("/device-address")
@Api(tags = "安装位置")
public class DeviceAddressController {

    @Autowired
    private IDeviceAddressService addressService;


    @PostMapping("/")
    public DeviceAddress add(@RequestBody DeviceAddress vo) {
        if (addressService.save(vo)) {
            return vo;
        } else {
            return null;
        }
    }

    @PutMapping("/")
    public DeviceAddress update(@RequestBody DeviceAddress vo) {
        if (addressService.updateById(vo)) {
            return vo;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return addressService.removeById(id);
    }

    @GetMapping("/{id}")
    public DeviceAddress get(@PathVariable("id") Integer id) {
        return addressService.getById(id);
    }

    @GetMapping("/")
    public Page<DeviceAddress> list(DeviceAddressVo vo) {
        DeviceAddress detail = new DeviceAddress();
        BeanUtils.copyProperties(vo, detail);
        Page<DeviceAddress> page = new Page<>((vo.getPn() - 1) * vo.getPs(), vo.getPs());
        return addressService.page(page, Wrappers.query(detail));
    }

}
