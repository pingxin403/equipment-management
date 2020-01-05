package com.hyp.ujs.em.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.hyp.ujs.em.commons.constant.DeviceDetailStatus;
import com.hyp.ujs.em.commons.constant.DeviceDetailStatusAutoConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.dto
 * hyp create at 20-1-4
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDto {

    @ExcelProperty(value = "序号", index = 0)
    private Integer id;

    @ExcelProperty(value = "名称", index = 2)
    private String name;

    @ExcelProperty(value = "编号", index = 1)
    private String code;

    @ExcelProperty(value = "过期日期", index = 10)
    private String endDate;

    @ExcelProperty(value = "状态", index = 3, converter = DeviceDetailStatusAutoConverter.class)
    private DeviceDetailStatus status;

    @ExcelProperty(value = "设备类id", index = 4)
    private Integer clzId;
    @ExcelProperty(value = "设备类", index = 5)
    private String clzName;
    @ExcelProperty(value = "设备组id", index = 6)
    private Integer groupId;
    @ExcelProperty(value = "设备组", index = 7)
    private String groupName;
    @ExcelProperty(value = "安装位置", index = 8)
    private String addressName;

    @ExcelProperty(value = "安装时间", index = 9)
    private String installDate;

}
