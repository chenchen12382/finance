package com.pz.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.base.BaseQuery;
import com.pz.dao.EmployeeDao;
import com.pz.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/2/7.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public PageList<Employee> selectForPage(BaseQuery query) {

        PageList<Employee> employees = employeeDao.selectForPage(query,query.buildPageBounds());
        return employees;
    }
}
