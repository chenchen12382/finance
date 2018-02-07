package com.pz.controller;

import com.pz.base.BaseController;
import com.pz.base.ResultInfo;
import com.pz.model.Center;
import com.pz.service.CenterService;
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

//    @Autowired
//    private CenterService centerService;
//
//
//
//
//
//    @RequestMapping("add")
//    @ResponseBody
//    public ResultInfo insert(Center center){
//
//        centerService.insert(center);
//
//        return success("添加成功");
//
//    }
//
//    @RequestMapping("selectForId")
//    @ResponseBody
//    public Center selectForId(Integer id){
//        Center center = centerService.selectForId(id);
//        return center;
//
//    }
//
//
//    @RequestMapping("update")
//    @ResponseBody
//    public  ResultInfo update(Center center){
//        centerService.update(center);
//        return success("修改成功");
//    }
//
//
//    @RequestMapping("delete")
//    @ResponseBody
//    public  ResultInfo delete(Integer id){
//        centerService.delete(id);
//        return success("删除成功");
//    }


}
