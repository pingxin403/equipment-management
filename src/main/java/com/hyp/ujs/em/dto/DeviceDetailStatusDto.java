package com.hyp.ujs.em.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

/**
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.dto
 * hyp create at 20-1-5
 **/
@Data
@Builder
@ApiModel("设备状态")
public class DeviceDetailStatusDto {
    private int code;
    private String name;
}
