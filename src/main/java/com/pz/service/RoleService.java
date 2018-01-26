package com.pz.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.base.BaseQuery;
import com.pz.dao.RoleDao;
import com.pz.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/26.
 */
@Service
public class RoleService  {
    @Autowired
    private RoleDao roleDao;

    public PageList<Role> findRoleForPage(BaseQuery query) {
        PageList<Role> roles=roleDao.findRoleForPage(query,query.buildPageBounds());
        return roles;
    }
}
