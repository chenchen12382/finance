package com.pz.dao;

import com.pz.model.ParentingTeacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2018/1/23.
 */
public interface TeacherDao {


    @Select("select * from t_qinzi_teacher where is_valid=1")
    List<ParentingTeacher> selectForPage();

    @Insert("insert into t_qinzi_teacher (off_class_num_start,off_class_num_over,class_money,is_valid,create_date,update_date) values " +
            "(#{offClassNumStart},#{offClassNumOver},#{classMoney},1,now(),now())")
    void insert(ParentingTeacher teacher);






}
