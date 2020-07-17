package com.gm.trending;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class TrendTradingBackTestServiceApplication {

    private static final Logger logger= LoggerFactory.getLogger(TrendTradingBackTestServiceApplication.class);

    public static void main(String[] args) {
        logger.info("TrendTradingBackTestServiceApplication 正在启动中··················");
        SpringApplication.run(TrendTradingBackTestServiceApplication.class);
        logger.info("TrendTradingBackTestServiceApplication 启动完毕，正在运行中··········");
    }
}
