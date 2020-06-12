package com.cloud.springcloud.service;

import com.cloud.springcloud.entities.CommentResult;
import com.cloud.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @description: service接口
 * @author: WangShisheng
 * @create: 2020-06-10 15:02
 **/
public interface PaymentService {

    /**
     * 增加
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
