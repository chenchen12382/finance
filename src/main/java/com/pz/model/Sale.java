package com.pz.model;

import com.pz.base.BaseModel;

/**
 * Created by Administrator on 2018/3/29.
 */
public class Sale extends BaseModel{
    private Integer zbfwStart;
    private Integer zbfwOver;
    private Double tcbz;

    public Integer getZbfwStart() {
        return zbfwStart;
    }

    public void setZbfwStart(Integer zbfwStart) {
        this.zbfwStart = zbfwStart;
    }

    public Integer getZbfwOver() {
        return zbfwOver;
    }

    public void setZbfwOver(Integer zbfwOver) {
        this.zbfwOver = zbfwOver;
    }

    public Double getTcbz() {
        return tcbz;
    }

    public void setTcbz(Double tcbz) {
        this.tcbz = tcbz;
    }
}
