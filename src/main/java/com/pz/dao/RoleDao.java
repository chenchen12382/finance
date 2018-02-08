package com.pz.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.base.BaseQuery;
import com.pz.model.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2018/1/26.
 */
public interface RoleDao {

    PageList<Role> findRoleForPage(BaseQuery query, PageBounds pageBounds);

    @Insert("insert into t_role (role_name,role_remark,is_valid,create_date,update_date) values (#{roleName},#{roleRemark},1,now(),now())")
    void insert(Role role);

    @Select("select * from t_role where id= #{id}")
    Role selectForId(@Param("id") Integer id);

    @Update("update t_role set role_name=#{roleName},role_remark=#{roleRemark},update_date=now() where id = #{id}")
    void update(Role role);

    @Update("update t_role set is_valid=0 where id=#{id}")
    void delete(@Param("id") Integer id);

    @Select("select * from t_role where is_valid=1")
    List<Role> findAllRole();
}
