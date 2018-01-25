package com.pz.controller;

import com.pz.base.BaseController;
import com.pz.base.ResultInfo;
import com.pz.model.LbsTeacher;
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


    @RequestMapping("selectForId")
    @ResponseBody
    public ParentingTeacher selectForId(Integer id){
        ParentingTeacher parentingTeacher = teacherService.selectForId(id);
        return parentingTeacher;
    }


    @RequestMapping("update")
    @ResponseBody
    public ResultInfo update(ParentingTeacher teacher){
        teacherService.update(teacher);
        return success("修改成功");

    }

    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo delete(Integer id){
        teacherService.delete(id);
        return success("删除成功");
    }


    @RequestMapping("add_lbs")
    @ResponseBody
    public ResultInfo insertForLbs(LbsTeacher teacher){

        teacherService.insertForLbs(teacher);
        return success("添加成功");
    }


    @RequestMapping("selectForIdLbs")
    @ResponseBody
    public LbsTeacher selectForIdLbs(Integer id){
        LbsTeacher lbsTeachers = teacherService.selectForIdLbs(id);
        return lbsTeachers;
    }

    @RequestMapping("update_lbs")
    @ResponseBody
    public ResultInfo update_lbs(LbsTeacher teacher){
        teacherService.update_lbs(teacher);
        return success("修改成功");

    }

    @RequestMapping("delete_lbs")
    @ResponseBody
    public ResultInfo deleteLbs(Integer id){
        teacherService.deleteLbs(id);
        return success("删除成功");
    }



}
