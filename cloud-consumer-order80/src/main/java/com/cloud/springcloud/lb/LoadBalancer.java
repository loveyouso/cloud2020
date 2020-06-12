package com.cloud.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @description:
 * @author: WangShisheng
 * @create: 2020-06-12 00:52
 **/
public interface LoadBalancer {

    /**
     * 获取serviceInstancess
     * @param serviceInstances
     * @return
     */
    ServiceInstance getInterface(List<ServiceInstance> serviceInstances);
}
