package com.pz.controller;
import com.pz.base.BaseController;
import com.pz.base.ResultInfo;
import com.pz.model.User;
import com.pz.service.UserService;
import com.pz.vo.UserLoginIdentity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by TW on 2017/7/31.
 */
@Controller
@RequestMapping("/")
public class UserController extends BaseController{

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


    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @RequestMapping("login")
    @ResponseBody
    public ResultInfo login(String userName,String password,HttpServletRequest request){

        UserLoginIdentity userLoginIdentity = userService.login(userName,password);
        request.getSession().setAttribute("user",userLoginIdentity);
        return success(userLoginIdentity);


    }


    @RequestMapping("main")
    public String main(){
        return "main";
    }

}
