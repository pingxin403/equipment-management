package com.hyp.ujs.em.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 保养任务
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_maintenance_task")
public class MaintenanceTask extends BaseBean {

    private static final long serialVersionUID = 1L;

    private Date nextDays;

    private Integer msId;


}
