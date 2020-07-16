package com.gm.trending.service.impl;

import com.alibaba.fastjson.JSON;
import com.gm.trending.common.Resp;
import com.gm.trending.service.IndexDataService;
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
@CacheConfig(cacheNames = "indexData")
public class IndexDataServiceImpl implements IndexDataService {

    private static final Logger logger= LoggerFactory.getLogger(IndexServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fetchThirdIndexDataFallback")
    @Cacheable(value="index_data",key="'indexData-code-'+#p0")
    @Override
    public Object fetchIndexData(String code) {
        List indexData=restTemplate.getForObject("http://localhost:8090/indexes/"+code+".json",List.class);
        indexData= IndexUtils.map2IndexData(indexData);
        Map data=new HashMap<String, Object>();
        data.put("indexData",indexData);
        Resp resp=new Resp("100002","获取indexData数据成功",data);
        return JSON.toJSON(resp);
    }

    @CachePut(value="index_data",key="'indexData-code-'+#p0")
    @Override
    public Object updateIndexData(String code) {
        logger.info("调用获取新的指数数据");
        return fetchIndexData(code);
    }

    @CacheEvict(value="index_data",key="'indexData-code-'+#p0")
    @Override
    public Object removeIndexData(String code) {
        logger.warn("删除缓存中存指定code的指数数据");
        return null;
    }

    public Object fetchThirdIndexDataFallback(String code,Throwable throwable)
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
