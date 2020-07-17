package com.gm.trending.service.impl;

import com.gm.trending.feign.IndexDataFeignClient;
import com.gm.trending.service.BackTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackTestServiceImpl implements BackTestService {

    @Autowired
    private IndexDataFeignClient indexDataFeignClient;

    @Override
    public Object getIndexData(String code) {
        return indexDataFeignClient.getIndexData(code);
    }

    @Override
    public Object updateIndexData(String code) {
        return indexDataFeignClient.updateIndexData(code);
    }

    @Override
    public Object removeIndexData(String code) {
        return indexDataFeignClient.removeIndexData(code);
    }
}
