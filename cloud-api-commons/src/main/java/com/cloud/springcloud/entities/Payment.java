package com.cloud.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 支付实体类
 * @author: WangShisheng
 * @create: 2020-03-14 09:06
 **/
@Data
@AllArgsConstructor  //全参构造器
@NoArgsConstructor  //空参构造器
public class Payment implements Serializable {

    /**
     * id主键
     */
    private Long id;

    /**
     * 序号
     */
    private String serial;
}
