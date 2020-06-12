package com.cloud.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 返回结果封装
 * @author: WangShisheng
 * @create: 2020-03-14 09:12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResult<T> {

    private Integer code;

    private String message;

    private T data;

    public CommentResult(Integer code,String message){
        this(code,message,null);
    }

}
