package com.pz.controller;

import com.pz.base.BaseController;
import com.pz.base.ResultInfo;
import com.pz.model.Compute;
import com.pz.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

        return success("插入成功！");
    }


    @RequestMapping("update")
    @ResponseBody
    public ResultInfo update(Compute compute){

        computeService.update(compute);

        return success("修改成功成功！");
    }




    @RequestMapping("insert")
    public String add(Compute compute){

        computeService.add(compute);

        return "redirect:/compute";
    }


//    /**
//     * 跳转到编辑框
//     * @param id
//     * @param model
//     * @return
//     */
//    @RequestMapping("update_form")
//    public String updateForm(Integer id, Model model){
//
//       Compute compute = computeService.selectForId(id);
//       model.addAttribute("")
//
//        return "compute";
//    }




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
