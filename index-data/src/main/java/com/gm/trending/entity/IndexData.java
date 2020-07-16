package com.gm.trending.entity;

import java.io.Serializable;

/**
 * @author Squirrel-Chen
 */
public class IndexData  implements Serializable {

    private static final long serialVersionUID = 6181028346388584036L;
    private String date;
    private float closePoint;

    @Override
    public String toString() {
        return "IndexData{" +
                "date='" + date + '\'' +
                ", closePoint=" + closePoint +
                '}';
    }

    public IndexData(String date, float closePoint) {
        this.date = date;
        this.closePoint = closePoint;
    }

    public IndexData(){}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getClosePoint() {
        return closePoint;
    }

    public void setClosePoint(float closePoint) {
        this.closePoint = closePoint;
    }
}
