package com.microService.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;
    public CommonResult(int code,String message){
        this(code,message,null);

    }
}
