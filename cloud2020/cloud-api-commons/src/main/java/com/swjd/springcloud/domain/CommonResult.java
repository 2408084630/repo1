package com.swjd.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//返回给前端的json对象
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;//状态码
    private String message;//提示信息
    private T data;//返回的对象信息

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }

}
