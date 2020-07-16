package com.gm.trending.service;

public interface IndexDataService {

    public Object fetchIndexData(String code);
    public Object updateIndexData(String code);
    public Object removeIndexData(String code);

}
