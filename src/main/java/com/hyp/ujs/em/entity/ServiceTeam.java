package com.hyp.ujs.em.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 服务班组
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_service_team")
public class ServiceTeam extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String name;

    private String desc;


}
