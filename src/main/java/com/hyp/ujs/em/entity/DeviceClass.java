package com.hyp.ujs.em.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 设备类
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_device_class")
public class DeviceClass extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String name;

    private String function;

    private String scene;


}
