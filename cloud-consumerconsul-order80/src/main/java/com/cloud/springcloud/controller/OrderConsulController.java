package com.cloud.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description:
 * @author: WangShisheng
 * @create: 2020-06-11 18:05
 **/
@RestController
@RequestMapping("/api/consumer")
public class OrderConsulController {

    //public static final String PAYMENT_RRL = "http://localhost:8001";
    public static final String INVOME_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/payment/consul")
    public String paymetZKInfo(){
        return  restTemplate.getForObject(INVOME_URL+"/api/payment/consul",String.class);
    }

}
