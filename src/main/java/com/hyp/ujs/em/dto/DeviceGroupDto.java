package com.hyp.ujs.em.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.dto
 * hyp create at 20-1-6
 **/
@Data
public class DeviceGroupDto {
    private String name;

    private String firm;

    private BigDecimal price;

    private Integer durableYears;

    private Integer clzId;

    private String clzName;
}
