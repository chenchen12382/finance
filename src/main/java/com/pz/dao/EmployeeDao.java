package com.pz.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.base.BaseQuery;
import com.pz.model.Employee;

/**
 * Created by Administrator on 2018/2/7.
 */

public interface EmployeeDao {

    PageList<Employee> selectForPage(BaseQuery query, PageBounds pageBounds);
}
