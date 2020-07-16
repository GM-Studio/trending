package com.gm.trending.utils;

import cn.hutool.core.convert.Convert;
import com.gm.trending.entity.Index;
import com.gm.trending.entity.IndexData;

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

    public static List<IndexData> map2IndexData(List<Map> temp) {
        List<IndexData> indexDatas = new ArrayList<>();
        for (Map map : temp) {
            String date = map.get("date").toString();
            float closePoint = Convert.toFloat(map.get("closePoint"));
            IndexData indexData = new IndexData();

            indexData.setDate(date);
            indexData.setClosePoint(closePoint);
            indexDatas.add(indexData);
        }

        return indexDatas;
    }

}
