package com.pz.service;

import com.pz.base.AssertUtil;
import com.pz.dao.TeacherDao;
import com.pz.model.ParentingTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/23.
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public List<ParentingTeacher> selectForPage() {

        List<ParentingTeacher> parentingTeachers= teacherDao.selectForPage();

        return parentingTeachers;
    }

    public void insert(ParentingTeacher teacher) {

        //参数验证
        AssertUtil.intIsNotEmpty(teacher.getOffClassNumStart(),"销课人数不能为空");
        AssertUtil.intIsNotEmpty(teacher.getOffClassNumOver(),"销课人数不能为空");
        AssertUtil.intIsNotEmpty(teacher.getClassMoney(),"课时费不能为空");


        teacherDao.insert(teacher);

    }
}
