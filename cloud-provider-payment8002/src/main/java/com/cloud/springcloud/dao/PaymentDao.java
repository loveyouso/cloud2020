package com.cloud.springcloud.dao;

import com.cloud.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description: dao接口
 * @author: WangShisheng
 * @create: 2020-03-14 09:15
 **/
@Mapper
public interface PaymentDao {

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
