package com.pz.controller;

import com.pz.base.BaseController;
import com.pz.base.ResultInfo;
import com.pz.model.ParentingTeacher;
import com.pz.service.TeacherService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/1/24.
 */
@Controller
@RequestMapping("teacher")
public class TeacherController extends BaseController{

    @Autowired
    private TeacherService teacherService;


    @RequestMapping("add")
    @ResponseBody
    public ResultInfo insert(ParentingTeacher teacher){

        teacherService.insert(teacher);
        return success("添加成功");
    }

}
