package com.hyp.ujs.em.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 设备组
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_device_group")
public class DeviceGroup extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String name;

    private String firm;

    private BigDecimal price;

    private Integer durableYears;

    private Integer clzId;

    private String clzName;


}
