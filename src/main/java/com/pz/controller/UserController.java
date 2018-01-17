package com.pz.controller;
import com.pz.model.User;
import com.pz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by TW on 2017/7/31.
 */
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("list")
    public String listUser(Model model) {
        logger.info("这是一个INFO日志");
        logger.debug("这是一个DEBUG日志");
        List<User> users = userService.findList();
        model.addAttribute("users", users);
        return "user_list";


    }

    @RequestMapping("find/{id}")
    @ResponseBody
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }


    @RequestMapping("login")
    public String login(){
        return "login";
    }




    @RequestMapping("main")
    public String main(){
        return "main";
    }

}
