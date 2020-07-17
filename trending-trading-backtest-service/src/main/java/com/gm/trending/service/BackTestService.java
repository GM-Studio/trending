package com.gm.trending.service;

/**
 * @author Squirrel-Chen
 */
public interface BackTestService {

    public Object getIndexData(String code);
    public Object updateIndexData(String code);
    public Object removeIndexData(String code);

}
