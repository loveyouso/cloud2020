package com.cloud.springcloud.controller;

import com.cloud.springcloud.entities.CommentResult;
import com.cloud.springcloud.entities.Payment;
import com.cloud.springcloud.service.PaymentService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description:
 * @author: WangShisheng
 * @create: 2020-06-10 15:08
 **/
@RestController
@RequestMapping("/api/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    @ApiOperation(value = "新增支付信息")
    public CommentResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("=======>插入结果：{}",result);
        if (result > 0){
            return new CommentResult(200,"success,serverPort: " + serverPort,result);
        }else{
            return new CommentResult(400,"error,serverPort: "+ serverPort,null);
        }
    }

    @GetMapping(value = "/get/{id}")
    @ApiOperation(value = "根据id获取付款信息")
    public CommentResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("=======>返回结果：{}",payment);
        if (payment != null){
            return new CommentResult(200,"success,serverPort: "+ serverPort,payment);
        }else{
            return new CommentResult(400,"error,serverPort: "+ serverPort,null);
        }
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
