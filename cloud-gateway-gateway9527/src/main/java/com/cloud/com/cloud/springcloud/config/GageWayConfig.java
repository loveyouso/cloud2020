package com.cloud.com.cloud.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: WangShisheng
 * @create: 2020-07-06 22:37
 **/
@Configuration
public class GageWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        /**
         * 配置了一个id为route-name的路由规则
         * 测试：通过本地网关，当访问http://localhost:9527/guonei时，会自动跳转地址：http://news.baidu.com/guonei
         *   https?
         */
        routes.route("path_route_cloud",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei"));
        routes.route("path_route_cloud",
                r -> r.path("/guoji").uri("http://news.baidu.com/guoji"));

        return routes.build();
    }
}
