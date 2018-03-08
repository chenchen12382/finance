package com.pz.model;

import com.pz.base.BaseModel;

/**
 * Created by Administrator on 2018/3/8.
 */
public class Compute extends BaseModel{

    private Integer dx;     //底薪 基本工资
    private Integer gwgz;   //岗位工资
    private Integer jxgz;   //绩效工资
    private Integer bmf;    //保密费
    private Integer tcjj;   //提成奖金
    private Integer bbj;    //报/续班奖金
    private Integer ksf;     // 课时费
    private Integer bfgz;     //补发工资
    private Integer ft;      //饭贴
    private Integer jt;      //津贴
    private Integer bsj;     //病事假
    private Integer kk;      //迟到/忘打卡扣款
    private Integer qtkk;    //其他扣款

    private Double gzze;     //总工资

    private  String name;   //姓名

    private  String work;    //职位

    private  String center;   //中心


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public Double getGzze() {
        return gzze;
    }

    public void setGzze(Double gzze) {
        this.gzze = gzze;
    }

    public Integer getDx() {
        return dx;
    }

    public void setDx(Integer dx) {
        this.dx = dx;
    }

    public Integer getGwgz() {
        return gwgz;
    }

    public void setGwgz(Integer gwgz) {
        this.gwgz = gwgz;
    }

    public Integer getJxgz() {
        return jxgz;
    }

    public void setJxgz(Integer jxgz) {
        this.jxgz = jxgz;
    }

    public Integer getBmf() {
        return bmf;
    }

    public void setBmf(Integer bmf) {
        this.bmf = bmf;
    }

    public Integer getTcjj() {
        return tcjj;
    }

    public void setTcjj(Integer tcjj) {
        this.tcjj = tcjj;
    }

    public Integer getBbj() {
        return bbj;
    }

    public void setBbj(Integer bbj) {
        this.bbj = bbj;
    }

    public Integer getKsf() {
        return ksf;
    }

    public void setKsf(Integer ksf) {
        this.ksf = ksf;
    }

    public Integer getBfgz() {
        return bfgz;
    }

    public void setBfgz(Integer bfgz) {
        this.bfgz = bfgz;
    }

    public Integer getFt() {
        return ft;
    }

    public void setFt(Integer ft) {
        this.ft = ft;
    }

    public Integer getJt() {
        return jt;
    }

    public void setJt(Integer jt) {
        this.jt = jt;
    }

    public Integer getBsj() {
        return bsj;
    }

    public void setBsj(Integer bsj) {
        this.bsj = bsj;
    }

    public Integer getKk() {
        return kk;
    }

    public void setKk(Integer kk) {
        this.kk = kk;
    }

    public Integer getQtkk() {
        return qtkk;
    }

    public void setQtkk(Integer qtkk) {
        this.qtkk = qtkk;
    }
}
