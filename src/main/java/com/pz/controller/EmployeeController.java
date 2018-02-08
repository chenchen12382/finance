package com.pz.controller;

import com.pz.base.BaseController;
import com.pz.base.ResultInfo;
import com.pz.model.Center;
import com.pz.model.Employee;
import com.pz.service.CenterService;
import com.pz.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/1/26.
 */
@RequestMapping("employee")
@Controller
public class EmployeeController extends BaseController {

    @Autowired
    private EmployeeService employeeService;





    @RequestMapping("add")
    @ResponseBody
    public ResultInfo insert(Employee employee){

        employeeService.insert(employee);

        return success("添加成功");

    }

    @RequestMapping("selectForId")
    @ResponseBody
    public Employee selectForId(Integer id){
        Employee employee = employeeService.selectForId(id);
        return employee;

    }


    @RequestMapping("update")
    @ResponseBody
    public  ResultInfo update(Employee employee){
        employeeService.update(employee);
        return success("修改成功");
    }


    @RequestMapping("delete")
    @ResponseBody
    public  ResultInfo delete(Integer id){
        employeeService.delete(id);
        return success("删除成功");
    }


}
