package com.gm.trending.service.impl;

import com.alibaba.fastjson.JSON;
import com.gm.trending.common.Resp;
import com.gm.trending.entity.Index;
import com.gm.trending.service.IndexService;
import com.gm.trending.utils.IndexUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fetchThirdIndexesFallback")
    @Cacheable(cacheNames="index_codes",key = "'all_codes'")
    @Override
    public Object fetchThirdIndexes() {
        List indexTemp= restTemplate.getForObject("http://localhost:8090/indexes/codes.json",List.class);
        indexTemp= IndexUtils.map2Index(indexTemp);
        Map data=new HashMap<String, Object>();
        data.put("indexes",indexTemp);
        Resp resp=new Resp("10001","获取数据成功",data);
        return JSON.toJSON(resp);
    }

    @CacheEvict(cacheNames="index_codes",key = "'all_codes'")
    @Override
    public Object removeIndexes() {
        logger.warn("删除缓存中存在的指数数据");
        return null;
    }

    @HystrixCommand(fallbackMethod = "fetchThirdIndexesFallback")
    @CachePut(cacheNames="index_codes",key = "'all_codes'")
    @Override
    public Object updateIndexes() {
        logger.info("调用获取新的指数数据");
        return fetchThirdIndexes();
    }


    public Object fetchThirdIndexesFallback(Throwable throwable)
    {
        if (throwable instanceof HystrixTimeoutException)
        {
            logger.error("远程调用出现异常，服务调用超时");
            /*
              此处应该接缓存数据
             */
            Resp resp=new Resp("E00001","远程调用异常，服务调用超时",null);
            return JSON.toJSON(resp);
        }
        return null;
    }
}
