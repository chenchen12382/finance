package com.pz.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.base.AssertUtil;
import com.pz.base.BaseQuery;
import com.pz.dao.EmployeeDao;
import com.pz.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void insert(Employee employee) {
        chickParam(employee);
        employeeDao.insert(employee);

    }

    public Employee selectForId(Integer id) {
        AssertUtil.intIsNotEmpty(id,"请选择.......");
        Employee employee = employeeDao.selectForId(id);
        return employee;
    }

    public void update(Employee employee) {
        chickParam(employee);
        employeeDao.update(employee);
    }

    public void delete(Integer id) {
        AssertUtil.intIsNotEmpty(id,"请选择.......");
        employeeDao.delete(id);
    }


    public void chickParam(Employee employee){
        AssertUtil.isNotEmpty(employee.getName(),"请填写姓名");
        AssertUtil.isNotEmpty(employee.getCenter(),"请填写中心");
        AssertUtil.isNotEmpty(employee.getPosition(),"请填写职位");
    }

    public List<Employee> findAll() {
        List<Employee> employees = employeeDao.findAll();
        return employees;
    }
}
