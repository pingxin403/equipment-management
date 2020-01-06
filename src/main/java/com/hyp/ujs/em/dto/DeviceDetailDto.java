package com.hyp.ujs.em.dto;

import com.hyp.ujs.em.commons.constant.DeviceDetailStatus;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.dto
 * hyp create at 20-1-6
 **/
@Data
public class DeviceDetailDto {
    private String name;

    private String code;

    private LocalDate endDate;

    private DeviceDetailStatus status;

    private Integer clzId;
    private String clzName;
    private Integer groupId;
    private String groupName;
    private String addressName;

    private LocalDate installDate;

}
