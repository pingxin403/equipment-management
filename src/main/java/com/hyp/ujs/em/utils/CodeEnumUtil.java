package com.hyp.ujs.em.utils;

import com.hyp.ujs.em.commons.constant.BaseCodeEnum;

/**
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.utils
 * hyp create at 20-1-4
 **/
public class CodeEnumUtil {

    public static <E extends Enum<?> & BaseCodeEnum> E codeOf(Class<E> enumClass, int code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }
}
