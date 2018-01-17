package com.pz.dao;

import com.pz.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by TW on 2017/7/31.
 */
//@Mapper
public interface UserDao {

    @Select("select * from t_user")
    List<User> findList();

    User findById(@Param(value = "id") Integer userId);
}
