package com.hyp.ujs.em.commons.data;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hyp.ujs.em.commons.constant.CommonCode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hyp
 * Project name is spring-boot-learn
 * Include in com.hyp.learn.async.commons
 * hyp create at 19-12-21
 **/
public class ServiceException extends RuntimeException implements Serializable {

    /**
     * 错误码
     */
    private CommonCode code;

    private Map<String, ? extends Object> errors;

    public ServiceException(CommonCode code, Map<String, Object> errors) {
        super(code.getMsg());
        this.code = code;
        this.errors = errors;
    }

    public ServiceException(String message, CommonCode code, Map<String, ? extends Object> errors) {
        super(message);
        this.code = code;
        this.errors = errors;
    }

    public ServiceException(String message, Throwable cause, CommonCode code, Map<String, ? extends Object> errors) {
        super(message, cause);
        this.code = code;
        this.errors = errors;
    }

    public ServiceException(Throwable cause, CommonCode code, Map<String, ? extends Object> errors) {
        super(cause.getMessage(), cause);
        this.code = code;
        this.errors = errors;
    }

    public ServiceException(CommonCode code) {
        super(code.getMsg());
        this.code = code;
        this.errors = new HashMap<>();
    }

    public ServiceException(String message, CommonCode code) {
        super(message);
        this.code = code;
        this.errors = new HashMap<>();
    }

    public ServiceException(String message, Throwable cause, CommonCode code) {
        super(message, cause);
        this.code = code;
    }

    public ServiceException(Throwable cause, CommonCode code) {
        super(cause.getMessage(), cause);
        this.code = code;
    }

    public CommonCode getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", this.getCode().getCode());
        map.put("message", this.getMessage());
        return JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue);
    }

    public Map<String, ? extends Object> getErrors() {
        return this.errors;
    }

    public Integer getCodeId() {
        return this.code.getCode();
    }
}

