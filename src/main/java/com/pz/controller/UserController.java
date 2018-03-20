package com.pz.controller;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.base.BaseController;
import com.pz.base.BaseQuery;
import com.pz.base.ResultInfo;
import com.pz.dto.ComputeFormQuery;
import com.pz.model.*;
import com.pz.service.*;
import com.pz.vo.UserLoginIdentity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by TW on 2017/7/31.
 */
@Controller
@RequestMapping("/")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private CenterService centerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ComputeService computeService;


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

    /**
     * 首页
     * @return
     */
    @RequestMapping("main")
    public String main(){
        return "main";
    }

    @RequestMapping("teacher")
    public String teacher(Model model){
        List<ParentingTeacher> parentingTeachers=teacherService.selectForPage();
        List<LbsTeacher> lbsTeachers = teacherService.selectForPageLbs();
        model.addAttribute("parentingTeachers",parentingTeachers);
        model.addAttribute("lbsTeachers",lbsTeachers);
        return "teacher";
    }

    /**
     * 角色管理
     * @return
     */
    @RequestMapping("role")
    public String role(Model model,BaseQuery query){
        PageList<Role> roles=roleService.findRoleForPage(query);
        model.addAttribute("roles",roles);
        model.addAttribute("page",roles.getPaginator());
        return "role";
    }

    @RequestMapping("test")
    public ResultInfo test(HttpServletRequest request){
        String session = request.getSession().getId();
        System.out.println(session);
        return success("成功！" );
    }

    @RequestMapping("employee")
    public String employee(Model model,BaseQuery query){

        PageList<Employee> employees = employeeService.selectForPage(query);
        List<Center> centers = centerService.findAllCenter();
        List<Role> roles = roleService.findAllRole();
        model.addAttribute("centers",centers);
        model.addAttribute("roles",roles);
        model.addAttribute("employees",employees);
        model.addAttribute("page",employees.getPaginator());

        return "employee";
    }

    @RequestMapping("center")
    public String center(Model model,BaseQuery query){
        PageList<Center> centers = centerService.selectForPage(query);
        model.addAttribute("centers",centers);
        model.addAttribute("page",centers.getPaginator());

        return "center";
    }

    /**
     * 计算
     */
    @RequestMapping("compute")
    public String compute(Model model,BaseQuery query){
          List<Employee> employees = employeeService.findAll();
          model.addAttribute("employees",employees);
        return "compute";
    }


    @RequestMapping("compute_form")
    public String computeForm(Model model,ComputeFormQuery query){

        PageList<Compute> computes = computeService.selectForPage(query);
        model.addAttribute("computes",computes);
        model.addAttribute("page",computes.getPaginator());

        return "compute_form";
    }


}
