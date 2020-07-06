package com.cloud.springcloud.service;

import com.cloud.springcloud.entities.CommentResult;
import com.cloud.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author: WangShisheng
 * @create: 2020-06-12 01:39
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     * 根据id获取
     * @param id
     * @return
     */
    @GetMapping(value = "/api/payment/get/{id}")
    CommentResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();

}
