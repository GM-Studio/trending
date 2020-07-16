package com.gm.trending;

import com.gm.trending.service.IndexDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableCaching
public class IndexDataApplication {

    private static final Logger logger= LoggerFactory.getLogger(IndexDataApplication.class);

    public static void main(String[] args) {
        logger.info("IndexDataApplication 正在启动中··················");
        SpringApplication.run(IndexDataApplication.class);
        logger.info("IndexDataApplication 启动完毕，正在运行中··········");
    }
}
