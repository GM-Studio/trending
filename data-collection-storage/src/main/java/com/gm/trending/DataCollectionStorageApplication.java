package com.gm.trending;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableCaching
public class DataCollectionStorageApplication {

    private static final Logger logger=LoggerFactory.getLogger(DataCollectionStorageApplication.class);

    public static void main(String[] args) {
        logger.info("DataCollectionStorageApplication 正在启动中··················");
        SpringApplication.run(DataCollectionStorageApplication.class);
        logger.info("DataCollectionStorageApplication 启动完毕，正在运行中··········");
    }

    @Bean
    RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

}
