package com.hyp.ujs.em.commons.data;

import com.alibaba.fastjson.JSON;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Collections;

/**
 * @author hyp
 * Project name is spring-boot-learn
 * Include in com.hyp.learn.async.commons
 * hyp create at 19-12-21
 **/
@ControllerAdvice(annotations = RestController.class)
public class GlobalResponseBodyHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType mediaType, Class converterType, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (null == body) {
            return CommonResult.of(Collections.emptyMap());
        } else if (!(body instanceof CommonResult)) {
            CommonResult responseResult = CommonResult.of(body);
            //因为handler处理类的返回类型是String，为了保证一致性，这里需要将ResponseResult转回去
            if (body instanceof String) {
                return JSON.toJSONString(responseResult);
            }
            return responseResult;
        }


        return body;
    }

}


