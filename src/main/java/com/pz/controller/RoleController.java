package com.pz.controller;

import com.pz.base.BaseController;
import com.pz.base.ResultInfo;
import com.pz.model.Role;
import com.pz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/1/26.
 */
@RequestMapping("role")
@Controller
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;





    @RequestMapping("add")
    @ResponseBody
    public ResultInfo insert(Role role){

        roleService.insert(role);

        return success("添加成功");

    }

    @RequestMapping("selectForId")
    @ResponseBody
    public Role selectForId(Integer id){
        Role role = roleService.selectForId(id);
        return role;

    }


    @RequestMapping("update")
    @ResponseBody
    public  ResultInfo update(Role role){
        roleService.update(role);
        return success("修改成功");
    }


    @RequestMapping("delete")
    @ResponseBody
    public  ResultInfo delete(Integer id){
        roleService.delete(id);
        return success("删除成功");
    }


}
