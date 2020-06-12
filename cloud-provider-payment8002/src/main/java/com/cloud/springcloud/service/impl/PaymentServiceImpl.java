package com.cloud.springcloud.service.impl;

import com.cloud.springcloud.dao.PaymentDao;
import com.cloud.springcloud.entities.CommentResult;
import com.cloud.springcloud.entities.Payment;
import com.cloud.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: WangShisheng
 * @create: 2020-06-10 15:03
 **/
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
       return paymentDao.getPaymentById(id);
    }
}
