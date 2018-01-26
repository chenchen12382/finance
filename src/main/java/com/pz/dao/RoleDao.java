package com.pz.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.base.BaseQuery;
import com.pz.model.Role;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2018/1/26.
 */
public interface RoleDao {

    @Select("select * from t_role where is_valid=1")
    PageList<Role> findRoleForPage(BaseQuery query, PageBounds pageBounds);
}
