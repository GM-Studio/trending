package com.gm.trending.service;

import com.gm.trending.entity.Index;

import java.util.List;

/**
 * @author Squirrel-Chen
 * @Name 获取第三方指数的service
 */
public interface IndexService {

    public Object fetchThirdIndexes ();

    public Object removeIndexes();

    public Object updateIndexes();

}
