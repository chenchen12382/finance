package com.pz.service;

import com.pz.base.AssertUtil;
import com.pz.dao.UserDao;
import com.pz.exception.ParamException;
import com.pz.model.User;
import com.pz.utils.MD5Util;
import com.pz.utils.UserIDBase64;
import com.pz.vo.UserLoginIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/7/31.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findList() {
        List<User> users = userDao.findList();
        return users;
    }

    public User findById(Integer id) {
       return userDao.findById(id);
    }

    public UserLoginIdentity login(String userName, String password) {

        // 非空验证
        AssertUtil.isNotEmpty(userName, "请输入用户名");
        AssertUtil.isNotEmpty(password, "请输入密码");

        // 根据用户名查询用户在验证
        User user = userDao.findByUserName(userName.trim());

        AssertUtil.notNull(user,"用户名或密码错误,请重新输入!");
        if (!MD5Util.md5Method(password).equals(user.getPassword())) {
            throw new ParamException(103, "用户名或密码错误,请重新输入!");
        }
        UserLoginIdentity userLoginIdentity = buildLoginIdentity(user);
        return userLoginIdentity;

    }

    private UserLoginIdentity buildLoginIdentity(User user) {
        UserLoginIdentity userLoginIdentity = new UserLoginIdentity();
        userLoginIdentity.setUserIdString(UserIDBase64.encoderUserID(user.getId()));
        userLoginIdentity.setRealName(user.getTrueName());
        userLoginIdentity.setUserName(user.getUserName());
        return userLoginIdentity;

    }
}
