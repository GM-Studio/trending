package com.gm.trending.controller;

import com.alibaba.fastjson.JSON;
import com.gm.trending.common.Resp;
import com.gm.trending.service.BackTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Squirrel-Chen
 */
@RestController
public class BackTestController {

    private static final Logger logger= LoggerFactory.getLogger(BackTestController.class);

    @Autowired
    private BackTestService backTestService;

    @RequestMapping(value = "/simulate/{code}",method = RequestMethod.GET)
    public Object getIndexes(@PathVariable("code")String code)
    {
        logger.info("获取指数Data数据");
        return backTestService.getIndexData(code);
    }

    @RequestMapping(value = "/simulate/{code}",method = RequestMethod.DELETE)
    public Object removeIndexes(@PathVariable("code")String code)
    {
        logger.info("删除指数Data数据");
        backTestService.removeIndexData(code);
        Resp resp=new Resp("D10000","删除指数数据成功",null);
        return JSON.toJSON(resp);
    }

    @RequestMapping(value = "/simulate/{code}",method = RequestMethod.PUT)
    public Object updateIndexes(@PathVariable("code")String code) {
        logger.info("更新指数Data数据");
        return backTestService.updateIndexData(code);
    }



}
