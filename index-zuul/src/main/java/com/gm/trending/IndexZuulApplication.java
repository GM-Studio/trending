package com.gm.trending;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableZuulProxy
public class IndexZuulApplication {

    private static final Logger logger= LoggerFactory.getLogger(IndexZuulApplication.class);

    public static void main(String[] args) {
        logger.info("IndexZuulApplication 正在启动中··················");
        SpringApplication.run(IndexZuulApplication.class);
        logger.info("IndexZuulApplication 启动完毕，正在运行中··········");
    }
}
