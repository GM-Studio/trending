package com.gm.trending.service.impl;

import com.alibaba.fastjson.JSON;
import com.gm.trending.common.Resp;
import com.gm.trending.service.IndexDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * @author Squirrel-Chen
 */
@Service
@CacheConfig(cacheNames = "indexData")
public class IndexDataServiceImpl implements IndexDataService {

    private static final Logger logger= LoggerFactory.getLogger(IndexDataServiceImpl.class);

    @Cacheable(value="index_data",key="'indexData-code-'+#p0")
    @Override
    public Object getIndexData(String code) {
        logger.info("从缓存取数据");
        return JSON.toJSON(new Resp("R00002","缓存暂无数据",null));
    }

    @CachePut(value="index_data",key="'indexData-code-'+#p0")
    @Override
    public Object updateIndexData(String code) {
        logger.warn("更新缓存数据");
        return null;
    }

    @CacheEvict(value="index_data",key="'indexData-code-'+#p0")
    @Override
    public Object removeIndexData(String code) {
        logger.warn("删除缓存数据");
        return null;
    }
}
