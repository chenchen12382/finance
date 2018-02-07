package com.pz.model;


import com.pz.base.BaseModel;

/**
 * Created by Administrator on 2017/9/14.
 */
public class Employee extends BaseModel {

    private String center;
    private String position; //职位
    private String name;

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
