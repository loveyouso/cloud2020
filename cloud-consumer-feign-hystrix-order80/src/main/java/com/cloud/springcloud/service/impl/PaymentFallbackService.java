package com.cloud.springcloud.service.impl;

import com.cloud.springcloud.service.PaymentHystrixService;

/**
 * @description:
 * @author: WangShisheng
 * @create: 2020-07-06 00:24
 **/
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }

}
