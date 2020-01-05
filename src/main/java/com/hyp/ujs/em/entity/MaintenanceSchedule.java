package com.hyp.ujs.em.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 检查计划
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_maintenance_schedule")
public class MaintenanceSchedule extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer period;


}
