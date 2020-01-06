package com.hyp.ujs.em.commons.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.commons
 * hyp create at 20-1-4
 **/
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public interface BaseCodeEnum {
    Integer getCode();

    @JsonValue
    String getMsg();


}
