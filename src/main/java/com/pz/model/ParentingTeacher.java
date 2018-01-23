package com.pz.model;

import com.pz.base.BaseModel;

/**
 * Created by Administrator on 2018/1/23.
 */
public class ParentingTeacher extends BaseModel{

    private Integer offClassNumStart; //消课人数开始
    private Integer offClassNumOver; //消课人数结束
    private Integer classMoney;       //课时费


    public Integer getOffClassNumStart() {
        return offClassNumStart;
    }

    public void setOffClassNumStart(Integer offClassNumStart) {
        this.offClassNumStart = offClassNumStart;
    }

    public Integer getOffClassNumOver() {
        return offClassNumOver;
    }

    public void setOffClassNumOver(Integer offClassNumOver) {
        this.offClassNumOver = offClassNumOver;
    }

    public Integer getClassMoney() {
        return classMoney;
    }

    public void setClassMoney(Integer classMoney) {
        this.classMoney = classMoney;
    }
}
