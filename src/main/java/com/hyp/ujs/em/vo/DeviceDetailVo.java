package com.hyp.ujs.em.vo;

import com.hyp.ujs.em.commons.constant.DeviceDetailStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.vo
 * hyp create at 20-1-5
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel
public class DeviceDetailVo extends BaseVo {

    @ApiModelProperty("设备名称")
    private String name;
    @ApiModelProperty("安装位置")
    private String addressName;

    @ApiModelProperty(value = "状态")
    private DeviceDetailStatus status;

    private Integer clzId;

    private Integer groupId;


}
