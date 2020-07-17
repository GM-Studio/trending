package com.gm.trending;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Squirrel-Chen
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
@EnableEurekaClient
public class ConfigServerApplication {

    private static final Logger logger= LoggerFactory.getLogger(ConfigServerApplication.class);

    public static void main(String[] args) {
        logger.info("ConfigServerApplication 正在启动中················");
        SpringApplication.run(ConfigServerApplication.class);
        logger.info("ConfigServerApplication 启动完毕，正在运行中·········");
    }
}
