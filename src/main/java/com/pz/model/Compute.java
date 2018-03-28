package com.pz.model;

import com.pz.base.BaseModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2018/3/8.
 */
public class Compute extends BaseModel{

    private String sfz;    //省份证号
    private Integer cqts;   //出勤天数
    private Integer yeybt;  //幼儿园补贴
    private Integer ccbt;   //出差补贴
    private Double jxxs;   //绩效系数
    private Double cjkk;   //产假扣款
    private Double sjkk;   //事假扣款
    private Double bjkk;   //病假扣款
    private Double kgkk;   //旷工扣款
    private Double cdkk;   //迟到扣款
    private Double yfgz;   //应发工资


    private Double grsbhj;  //个人社保合计
    private Double grgjj;  //个人公积金
    private Double grsds;  //个人所得税
    private Double qysbhj; //企业社保合计
    private Double qygjj;  //企业公积金

    private Integer yjtc; //业绩提成
    private Integer xkrs;  //消课人数


    private Integer gzbc;  //工资补差



    private Integer dx;     //底薪 基本工资
    private Integer gwgz;   //岗位工资
    private Integer jxgz;   //绩效工资
    private Integer bmf;    //保密费
    private Double tcjj;   //提成奖金
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

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date start;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date over;


    public Integer getGzbc() {
        return gzbc;
    }

    public void setGzbc(Integer gzbc) {
        this.gzbc = gzbc;
    }

    public Double getGrsbhj() {
        return grsbhj;
    }

    public void setGrsbhj(Double grsbhj) {
        this.grsbhj = grsbhj;
    }

    public Double getGrgjj() {
        return grgjj;
    }

    public void setGrgjj(Double grgjj) {
        this.grgjj = grgjj;
    }

    public Double getGrsds() {
        return grsds;
    }

    public void setGrsds(Double grsds) {
        this.grsds = grsds;
    }

    public Double getQysbhj() {
        return qysbhj;
    }

    public void setQysbhj(Double qysbhj) {
        this.qysbhj = qysbhj;
    }

    public Double getQygjj() {
        return qygjj;
    }

    public void setQygjj(Double qygjj) {
        this.qygjj = qygjj;
    }

    public Double getYfgz() {
        return yfgz;
    }

    public void setYfgz(Double yfgz) {
        this.yfgz = yfgz;
    }

    public Double getJxxs() {
        return jxxs;
    }

    public void setJxxs(Double jxxs) {
        this.jxxs = jxxs;
    }

    public Integer getCcbt() {
        return ccbt;
    }

    public void setCcbt(Integer ccbt) {
        this.ccbt = ccbt;
    }

    public Integer getYeybt() {
        return yeybt;
    }

    public void setYeybt(Integer yeybt) {
        this.yeybt = yeybt;
    }

    public String getSfz() {
        return sfz;
    }

    public void setSfz(String sfz) {
        this.sfz = sfz;
    }

    public Integer getCqts() {
        return cqts;
    }

    public void setCqts(Integer cqts) {
        this.cqts = cqts;
    }


    public Double getCjkk() {
        return cjkk;
    }

    public void setCjkk(Double cjkk) {
        this.cjkk = cjkk;
    }

    public Double getSjkk() {
        return sjkk;
    }

    public void setSjkk(Double sjkk) {
        this.sjkk = sjkk;
    }

    public Double getBjkk() {
        return bjkk;
    }

    public void setBjkk(Double bjkk) {
        this.bjkk = bjkk;
    }

    public Double getKgkk() {
        return kgkk;
    }

    public void setKgkk(Double kgkk) {
        this.kgkk = kgkk;
    }

    public Double getCdkk() {
        return cdkk;
    }

    public void setCdkk(Double cdkk) {
        this.cdkk = cdkk;
    }


    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getOver() {
        return over;
    }

    public void setOver(Date over) {
        this.over = over;
    }

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

    public Double getTcjj() {
        return tcjj;
    }

    public void setTcjj(Double tcjj) {
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

    public Integer getYjtc() {
        return yjtc;
    }

    public void setYjtc(Integer yjtc) {
        this.yjtc = yjtc;
    }

    public Integer getXkrs() {
        return xkrs;
    }

    public void setXkrs(Integer xkrs) {
        this.xkrs = xkrs;
    }
}
