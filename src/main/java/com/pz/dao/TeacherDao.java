package com.pz.dao;

import com.pz.model.LbsTeacher;
import com.pz.model.ParentingTeacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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


    @Select("select * from t_qinzi_teacher where id=#{id} and is_valid=1")
    ParentingTeacher selectForId(@Param("id") Integer id);

    @Update("update t_qinzi_teacher set off_class_num_start=#{offClassNumStart},off_class_num_over=#{offClassNumOver},class_money=#{classMoney}, " +
            " update_date=now() where id=#{id}")
    void update(ParentingTeacher teacher);

    @Update("update t_qinzi_teacher set is_valid=0 where id=#{id}")
    void delete(@Param("id") Integer id);

    @Select("select * from t_lbs_teacher where is_valid=1")
    List<LbsTeacher> selectForPageLbs();

    @Insert("insert into t_lbs_teacher (level,off_class_num,class_money,is_valid,create_date,update_date) values " +
            "(#{level},'按出勤人数计算',#{classMoney},1,now(),now())")
    void insertForLbs(LbsTeacher teacher);

    @Select("select * from t_lbs_teacher where id=#{id} and is_valid=1")
    LbsTeacher selectForIdLbs(@Param("id") Integer id);

    @Update("update t_lbs_teacher set level=#{level},class_money=#{classMoney}, " +
            " update_date=now() where id=#{id}")
    void update_lbs(LbsTeacher teacher);

    @Update("update t_lbs_teacher set is_valid=0 where id=#{id}")
    void deleteLbs(@Param("id") Integer id);

    @Select("select class_money from t_lbs_teacher where is_valid=1 and level=#{tempWork}")
    Integer findByTemp(@Param("tempWork") String tempWork);
}
