package com.pz.model;

import com.pz.base.BaseModel;

/**
 * Created by Administrator on 2018/1/25.
 */
public class LbsTeacher extends BaseModel {

    private String level;
    private String offClassNum;
    private Integer classMoney;


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOffClassNum() {
        return offClassNum;
    }

    public void setOffClassNum(String offClassNum) {
        this.offClassNum = offClassNum;
    }

    public Integer getClassMoney() {
        return classMoney;
    }

    public void setClassMoney(Integer classMoney) {
        this.classMoney = classMoney;
    }
}
