package com.pz.dao;

import com.pz.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2018/1/16.
 */
@Mapper
public interface IndexDao {

    @Select("select * from t_user ")
    public User selectUser();
}
