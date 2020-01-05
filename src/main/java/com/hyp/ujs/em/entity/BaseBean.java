package com.hyp.ujs.em.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.bean
 * hyp create at 20-1-4
 **/
@Data
public class BaseBean implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;

    @TableLogic //标记逻辑删除属性
    private Integer flag;
}
