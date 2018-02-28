package com.pz.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.base.BaseQuery;
import com.pz.model.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2018/2/7.
 */

public interface EmployeeDao {

    PageList<Employee> selectForPage(BaseQuery query, PageBounds pageBounds);

    @Insert("insert into t_employee (name,center,position,is_valid,create_date,update_date) values (#{name},#{center},#{position},1,now(),now())")
    void insert(Employee employee);

    @Select("select * from t_employee where id=#{id} and is_valid=1")
    Employee selectForId(@Param("id") Integer id);

    @Update("update t_employee set name=#{name},center=#{name},position=#{position},update_date=now() where id=#{id} ")
    void update(Employee employee);

    @Update("update t_employee set is_valid = 0 where id=#{id}")
    void delete(@Param("id") Integer id);

    @Select("select * from t_employee where is_valid=1")
    List<Employee> findAll();
}
