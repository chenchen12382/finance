package com.pz.service;

import com.pz.dao.IndexDao;
import com.pz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/16.
 */
@Service
public class IndexService {
    @Autowired
    private IndexDao indexDao;

    public User test() {
        User user  = new User();
        user.setUserName("cc");
        user.setPassword("123456");

        return user;
    }

    public User selectUser() {
        User user=indexDao.selectUser();
        return user;
    }
}
