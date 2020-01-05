package com.hyp.ujs.em.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 员工
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_worker")
public class Worker extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String realName;

    private String desc;

    private Integer serviceId;

    private String serviceName;

    private String phone;

    private String nickName;

    private String avatarUrl;

    private String openId;



}
