package com.gm.trending;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


/**
 * @author Squirrel-Chen
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCaching
public class IndexCodeApplication {

    private static final Logger logger= LoggerFactory.getLogger(IndexCodeApplication.class);

    public static void main(String[] args) {
        logger.info("IndexCodeApplication 正在启动中··················");
        SpringApplication.run(IndexCodeApplication.class);
        logger.info("IndexCodeApplication 启动完毕，正在运行中··········");
    }

}
