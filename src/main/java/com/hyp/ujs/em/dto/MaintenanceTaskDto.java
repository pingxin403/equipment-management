package com.hyp.ujs.em.dto;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.dto
 * hyp create at 20-1-6
 **/
@Data
public class MaintenanceTaskDto {
    private Date nextDays;

    private Integer msId;

}
