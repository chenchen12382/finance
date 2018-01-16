package com.pz.controller;

import com.pz.model.User;
import com.pz.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/1/16.
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;


    @RequestMapping("/")
    public String login(Model model){
        User user=indexService.test();
        model.addAttribute("user",user);
        System.out.println("hello world");
        System.out.println("aaa");
        return "login";
    }

    @RequestMapping("login")
    public String index() {
        User user=indexService.selectUser();
        return "main";
    }
}
