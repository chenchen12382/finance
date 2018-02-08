package com.pz.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.base.AssertUtil;
import com.pz.base.BaseQuery;
import com.pz.dao.RoleDao;
import com.pz.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void insert(Role role) {
        AssertUtil.isNotEmpty(role.getRoleName(),"请输入角色名");
        roleDao.insert(role);

    }

    public Role selectForId(Integer id) {
       Role role= roleDao.selectForId(id);
       return role;
    }

    public void update(Role role) {
        AssertUtil.isNotEmpty(role.getRoleName(),"请输入角色名");
        roleDao.update(role);

    }


    public void delete(Integer id) {

        AssertUtil.intIsNotEmpty(id,"请选择后删除！");
        roleDao.delete(id);
    }

    public List<Role> findAllRole() {

        List<Role> roles=  roleDao.findAllRole();
        return roles;
    }
}
