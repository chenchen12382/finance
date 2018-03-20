package com.pz.controller;

import com.pz.base.BaseController;
import com.pz.base.ResultInfo;
import com.pz.model.Compute;
import com.pz.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2018/3/8.
 */

@RequestMapping("compute")
@Controller
public class ComputeController extends BaseController {

    @Autowired
    private ComputeService computeService;

    @RequestMapping("add")
    @ResponseBody
    public ResultInfo insert(Compute compute){

        computeService.insert(compute);

        return success("结果为："+compute.getGzze());
    }


    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo delete(Integer id){

        computeService.delete(id);

        return success("删除成功!");

    }



    @RequestMapping("readExcel")
    @ResponseBody
    public ResultInfo readExcel(@RequestParam(value = "upExl", required = false) MultipartFile upExl){
        computeService.readExcel(upExl);
        return success("导入成功");
    }

}
