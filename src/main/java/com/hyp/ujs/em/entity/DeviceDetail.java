package com.hyp.ujs.em.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hyp.ujs.em.commons.constant.DeviceDetailStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * <p>
 * 设备
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_device_detail")
public class DeviceDetail extends BaseBean {

    private static final long serialVersionUID = 1L;

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
