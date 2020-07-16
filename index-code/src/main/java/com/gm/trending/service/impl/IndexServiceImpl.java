package com.gm.trending.service.impl;

import com.alibaba.fastjson.JSON;
import com.gm.trending.common.Resp;
import com.gm.trending.service.IndexService;
import com.gm.trending.utils.IndexUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Squirrel-Chen
 */
@Service
@CacheConfig(cacheNames = {"indexes"})
public class IndexServiceImpl implements IndexService {

    private static final Logger logger=LoggerFactory.getLogger(IndexServiceImpl.class);


    @Cacheable(cacheNames="index_codes",key = "'all_codes'")
    @Override
    public Object getIndexCode() {

        logger.info("从redis获取数据");
        return JSON.toJSON(new Resp("R00001","缓存暂无数据",null));
    }

    @CacheEvict(cacheNames="index_codes",key = "'all_codes'")
    @Override
    public Object removeIndexCode() {

        logger.warn("删除缓存中存在的指数数据");
        return null;
    }

    @CachePut(cacheNames="index_codes",key = "'all_codes'")
    @Override
    public Object updateIndexCode() {

        logger.info("更新缓存里的数据");
        return getIndexCode();
    }
}
