package com.hyp.ujs.em.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyp.ujs.em.commons.constant.DeviceTaskStatus;
import com.hyp.ujs.em.dto.DeviceDetailStatusDto;
import com.hyp.ujs.em.entity.DeviceDetail;
import com.hyp.ujs.em.mapper.DeviceDetailMapper;
import com.hyp.ujs.em.service.IDeviceDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 设备 服务实现类
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@Service
public class DeviceDetailServiceImpl extends ServiceImpl<DeviceDetailMapper, DeviceDetail> implements IDeviceDetailService {

    @Override
    public List<DeviceDetailStatusDto> listDeviceStatus() {
        return Stream.of(DeviceTaskStatus.values())
                .map(
                        (item) -> DeviceDetailStatusDto.builder()
                                .name(item.getMsg())
                                .code(item.getCode())
                                .build()

                ).collect(Collectors.toList());
    }
}
