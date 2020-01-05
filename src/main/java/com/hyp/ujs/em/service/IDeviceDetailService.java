package com.hyp.ujs.em.service;

import com.hyp.ujs.em.dto.DeviceDetailStatusDto;
import com.hyp.ujs.em.entity.DeviceDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 设备 服务类
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
public interface IDeviceDetailService extends IService<DeviceDetail> {

    public List<DeviceDetailStatusDto> listDeviceStatus();

}
