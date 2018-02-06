package com.pz.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.base.BaseQuery;
import com.pz.model.Center;

/**
 * Created by Administrator on 2018/2/6.
 */
public interface CenterDao {


    PageList<Center> selectForPage(BaseQuery query, PageBounds pageBounds);
}
