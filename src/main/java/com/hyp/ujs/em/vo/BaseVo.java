package com.hyp.ujs.em.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.vo
 * hyp create at 20-1-5
 **/
@Data
public class BaseVo {
    @ApiModelProperty(value = "页码", example = "1")
    @Min(1)
    private Integer pn = 1;
    @ApiModelProperty(value = "每页大小", example = "10")
    @Max(30)
    private Integer ps = 10;
}
