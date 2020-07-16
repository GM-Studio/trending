package com.gm.trending.utils;

import com.alibaba.fastjson.JSON;
import com.gm.trending.common.Resp;
import com.gm.trending.entity.Index;
import com.gm.trending.service.IndexDataService;
import com.gm.trending.service.IndexService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import java.util.Date;
import java.util.List;

/**
 *  此处需要注意json object 互换问题 在此留个坑，需要要埋
 */

public class IndexSyncJob extends QuartzJobBean  {

    private static final Logger logger=LoggerFactory.getLogger(IndexSyncJob.class);


    @Autowired
    private IndexService indexService;

    @Autowired
    private IndexDataService indexDataService;


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        logger.info("任务定时器启动，定时爬取新的数据信息"+ new Date());
        Object json=indexService.updateIndexes();
        Resp resp= JSON.toJavaObject((JSON) json, Resp.class);
        List indexes= (List) resp.getData().get("indexes");
        List<Index> indexList= JSON.parseArray(indexes.toString(),Index.class);

        for (Index index:indexList)
        {
            logger.info("定时爬取新的indexData数据");
            indexDataService.updateIndexData(index.getCode());
        }

        logger.info("定时任务结束····························"+new Date());
    }
}
