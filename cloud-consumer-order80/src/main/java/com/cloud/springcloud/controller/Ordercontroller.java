package com.cloud.springcloud.controller;

import com.cloud.springcloud.entities.CommentResult;
import com.cloud.springcloud.entities.Payment;
import com.cloud.springcloud.lb.LoadBalancer;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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
    public static final String PAYMENT_RRL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/payment/create")
    @ApiOperation(value = "新增支付信息")
    public CommentResult<Payment> create(Payment payment){
        return  restTemplate.postForObject(PAYMENT_RRL+"/api/payment/create",payment,CommentResult.class);
    }

    @GetMapping(value = "/payment/get/{id}")
    @ApiOperation(value = "根据id获取付款信息")
    public CommentResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_RRL+"/api/payment/get/"+id,CommentResult.class);
    }

    @GetMapping(value = "/lb")
    public String getPaymentLb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance anInterface = loadBalancer.getInterface(instances);
        URI uri = anInterface.getUri();
        return restTemplate.getForObject(uri + "/api/payment/lb",String.class);
    }

}
