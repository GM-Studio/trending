package com.gm.trending.controller;

import com.alibaba.fastjson.JSON;
import com.gm.trending.common.Resp;
import com.gm.trending.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Squirrel-Chen
 */
@RestController
public class IndexController {

    private static final Logger logger=LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private IndexService indexService;


    @RequestMapping(value = "/IndexesCodes",method = RequestMethod.GET)
    public Object getIndexes()
    {
        logger.debug("端口为8002的服务响应请求");
        logger.info("获取指数数据");
        return indexService.getIndexCode();
    }

    @RequestMapping(value = "/IndexesCodes",method = RequestMethod.DELETE)
    public Object removeIndexes()
    {
        logger.info("删除指数数据");
        indexService.removeIndexCode();
        Resp resp=new Resp("D10000","删除指数数据成功",null);
        return JSON.toJSON(resp);
    }

    @RequestMapping(value="/IndexesCodes",method = RequestMethod.PUT)
    public Object updateIndexes() {
        logger.info("更新指数数据");
        return indexService.updateIndexCode();
    }




}

