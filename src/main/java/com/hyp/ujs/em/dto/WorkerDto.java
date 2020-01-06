package com.hyp.ujs.em.dto;

import lombok.Data;

/**
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.dto
 * hyp create at 20-1-6
 **/
@Data
public class WorkerDto {
    private String realName;

    private String desc;

    private Integer serviceId;

    private String serviceName;

    private String phone;

    private String nickName;

    private String avatarUrl;

    private String openId;
}
