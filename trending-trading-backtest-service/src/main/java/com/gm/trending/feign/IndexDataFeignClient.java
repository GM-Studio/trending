package com.gm.trending.feign;

import com.gm.trending.feign.fallback.IndexDataFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author Squirrel-Chen
 */
@FeignClient(value="index-data-service",fallbackFactory = IndexDataFeignFallback.class)

public interface IndexDataFeignClient {

    @GetMapping("/IndexData/{code}")
    public Object getIndexData(@PathVariable("code") String code);
    @PutMapping("/IndexData/{code}")
    public Object updateIndexData(@PathVariable("code") String code);
    @DeleteMapping("/IndexData/{code}")
    public Object removeIndexData(@PathVariable("code") String code);

}
