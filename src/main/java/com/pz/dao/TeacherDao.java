package com.pz.dao;

import com.pz.model.ParentingTeacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2018/1/23.
 */
public interface TeacherDao {


    @Select("select * from t_qinzi_teacher where is_valid=1")
    List<ParentingTeacher> selectForPage();
}
