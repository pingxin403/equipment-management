package com.hyp.ujs.em.commons.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hyp.ujs.em.commons.constant.CommonCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.util.Collections;

/**
 * @author hyp
 * Project name is spring-boot-learn
 * Include in com.hyp.learn.async.commons
 * hyp create at 19-12-21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult {

    public static Integer CODE_SUCCESS = CommonCode.SUCCESS.getCode();

    /**
     * 错误码
     */
    private Integer code;
    /**
     * 错误提示
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;

    public static CommonResult of(Object data) {
        return new CommonResult(CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMsg(), data);
    }

    public static CommonResult of(Exception e) {

        return new CommonResult(CommonCode.SYS_ERROR.getCode(), e.getMessage(), Collections.emptyMap());
    }

    public static CommonResult of(Exception e, Integer code) {

        return new CommonResult(code, e.getMessage(), Collections.emptyMap());
    }

    /**
     * 将传入的 result 对象，转换成另外一个泛型结果的对象
     * <p>
     * 因为 A 方法返回的 CommonResult 对象，不满足调用其的 B 方法的返回，所以需要进行转换。
     *
     * @return 新的 CommonResult 对象
     */
    public static CommonResult error(Integer code, String message) {
        Assert.isTrue(!CODE_SUCCESS.equals(code), "code 必须是错误的！");
        CommonResult result = new CommonResult();
        result.code = code;
        result.message = message;
        return result;
    }

    public static CommonResult success(Object data) {
        return CommonResult.of(data);
    }

    @JsonIgnore // 忽略，避免 jackson 序列化给前端
    public boolean isSuccess() { // 方便判断是否成功
        return CODE_SUCCESS.equals(code);
    }

    @JsonIgnore // 忽略，避免 jackson 序列化给前端
    public boolean isError() { // 方便判断是否失败
        return !isSuccess();
    }
}
