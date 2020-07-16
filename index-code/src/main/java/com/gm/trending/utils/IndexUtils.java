package com.gm.trending.utils;


import com.gm.trending.entity.Index;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Squirrel-Chen
 */
public class IndexUtils {

    public static List<Index> map2Index(List<Map> indexmap)
    {
        List<Index> indexList=new ArrayList<>();
        for (Map map:indexmap)
        {
            String code=map.get("code").toString();
            String name=map.get("name").toString();
            Index index=new Index(code,name);
            indexList.add(index);
        }
        if (indexList.size()!=0)
        {
            return indexList;
        }
        return null;
    }



}
