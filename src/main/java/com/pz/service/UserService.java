package com.pz.service;

import com.pz.dao.UserDao;
import com.pz.model.User;
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
}
