package com.cloud.springcloud.controller;

import com.cloud.springcloud.entities.CommentResult;
import com.cloud.springcloud.entities.Payment;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description:
 * @author: WangShisheng
 * @create: 2020-06-10 16:36
 **/
@RestController
@RequestMapping("/api/consumer")
@Slf4j
public class Ordercontroller {

    //public static final String PAYMENT_RRL = "http://localhost:8001";
    public static final String INVOME_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/payment/zk")
    @ApiOperation(value = "测试zookeeper")
    public String paymetZKInfo(){
        return  restTemplate.getForObject(INVOME_URL+"/api/payment/zk",String.class);
    }

}
