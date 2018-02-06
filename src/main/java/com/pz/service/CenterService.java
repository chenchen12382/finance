package com.pz.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.base.BaseQuery;
import com.pz.dao.CenterDao;
import com.pz.model.Center;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
