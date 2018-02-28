package com.pz.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.base.AssertUtil;
import com.pz.base.BaseQuery;
import com.pz.dao.CenterDao;
import com.pz.model.Center;
import com.pz.model.Employee;
import com.pz.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/2/6.
 */
@Service
public class CenterService {

    @Autowired
    private CenterDao centerDao;




    /**
     * 查询所有center
     * @param query
     * @return
     */
    public PageList<Center> selectForPage(BaseQuery query) {

        PageList<Center> centers = centerDao.selectForPage(query,query.buildPageBounds());
        return centers;

    }

    public void insert(Center center) {
        chickParam(center);
        centerDao.insert(center);

    }

    public Center selectForId(Integer id) {
//        AssertUtil.intIsNotEmpty(id,"请选择后查询！");
      Center center= centerDao.selectForId(id);
        return center;
    }


    public void delete(Integer id) {
        AssertUtil.intIsNotEmpty(id,"请选择");
        centerDao.delete(id);

    }

    public void update(Center center) {

        chickParam(center);
        centerDao.update(center);
    }


    public void chickParam(Center center){
        AssertUtil.isNotEmpty(center.getCenter(),"请输入中心！");
        AssertUtil.isNotEmpty(center.getDistrict(),"请输入区域");
    }

    public List<Center> findAllCenter() {
        List<Center> centers = centerDao.findAllCenter();
        return centers;
    }


}
