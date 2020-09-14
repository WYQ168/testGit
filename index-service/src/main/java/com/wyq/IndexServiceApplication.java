package com.wyq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication

//通过各种开启式注解，开启各类SpringCloud的组件支持
@EnableEurekaClient
@EnableFeignClients //开启声明式REST调用的功能
@EnableCircuitBreaker //熔断器
@EnableHystrixDashboard //熔断器监控平台
public class IndexServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(IndexServiceApplication.class, args);
    }
}
