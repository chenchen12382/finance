package com.pz.service;

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
}
