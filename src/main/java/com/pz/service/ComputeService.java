package com.pz.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.base.AssertUtil;
import com.pz.base.BaseQuery;
import com.pz.dao.ComputeDao;
import com.pz.model.Compute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/3/8.
 */
@Service
public class ComputeService {

    @Autowired
    private ComputeDao computeDao;


    public void insert(Compute compute) {

        AssertUtil.intIsNotEmpty(compute.getDx(),"请输入基本薪资！");

        //薪资计算
        AssertUtil.isNotEmpty(compute.getName(),"请选择员工！");

       Integer dx =  compute.getDx();
        Integer gwgz =  compute.getGwgz();
        if(gwgz==null){
            gwgz=0;
            compute.setGwgz(0);
        }
        Integer jxgz =  compute.getJxgz();
        if(jxgz==null){
            jxgz=0;
            compute.setJxgz(0);
        }
        Integer bmf =  compute.getBmf();
        if(bmf==null){
            bmf=0;
            compute.setBmf(0);
        }
        Integer tcjj =  compute.getTcjj();
        if(tcjj==null){
            tcjj=0;
            compute.setTcjj(0);
        }
        Integer bbj =  compute.getBbj();
        if(bbj==null){
            bbj=0;
            compute.setBbj(0);
        }
        Integer ksf =   compute.getKsf();
        if(ksf==null){
            ksf=0;
            compute.setKsf(0);
        }
        Integer bfgz =  compute.getBfgz();
        if(bfgz==null){
            bfgz=0;
            compute.setBfgz(0);
        }
        Integer ft =   compute.getFt();
        if(ft==null){
            ft=0;
            compute.setFt(0);
        }
        Integer jt =   compute.getJt();
        if(jt==null){
            jt=0;
            compute.setJt(0);
        }
        Integer bsj =    compute.getBsj();
        if(bsj==null){
            bsj=0;
            compute.setBsj(0);
        }
        Integer kk =   compute.getKk();
        if(kk==null){
            kk=0;
            compute.setKk(0);
        }
        Integer qtkk =   compute.getQtkk();
        if(qtkk==null){
            qtkk=0;
            compute.setQtkk(0);
        }


        Integer count = dx+gwgz+jxgz+bmf+tcjj+bbj+ksf+bfgz+ft+jt-bsj-kk-qtkk;
        System.out.println(count);

        compute.setGzze(Double.valueOf(count));

        computeDao.insert(compute);



    }

    public PageList<Compute> selectForPage(BaseQuery query) {

        PageList<Compute> computes = computeDao.selectForPage(query,query.buildPageBounds());

        return computes;

    }


    public void delete(Integer id) {

        computeDao.delete(id);

    }
}
