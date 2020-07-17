package com.gm.trending.feign.fallback;

import com.alibaba.fastjson.JSON;
import com.gm.trending.common.Resp;
import com.gm.trending.feign.IndexDataFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class IndexDataFeignFallback  implements FallbackFactory<IndexDataFeignClient> {

    private static final Logger logger=LoggerFactory.getLogger(IndexDataFeignFallback.class);


    @Override
    public IndexDataFeignClient create(Throwable throwable) {
        return new IndexDataFeignClient() {

            @Override
            public Object getIndexData(String code) {

                logger.error("获取指数数据失败，请求回退");
                Resp resp=new Resp("E00001","请求获取失败",null);
                return JSON.toJSON(resp);

            }

            @Override
            public Object updateIndexData(String code) {

                logger.error("更新指数数据失败，请求回退");
                Resp resp=new Resp("U00001","请求更新失败",null);
                return JSON.toJSON(resp);

            }

            @Override
            public Object removeIndexData(String code) {

                logger.error("删除指数数据失败，请求回退");
                Resp resp=new Resp("D00001","请求删除失败",null);
                return JSON.toJSON(resp);

            }
        };
    }
}
