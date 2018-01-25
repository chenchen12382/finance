package com.pz.service;

import com.pz.base.AssertUtil;
import com.pz.dao.TeacherDao;
import com.pz.model.LbsTeacher;
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
        chickParam(teacher);
        teacherDao.insert(teacher);

    }

    public ParentingTeacher selectForId(Integer id) {
        ParentingTeacher parentingTeacher= teacherDao.selectForId(id);
        return parentingTeacher;

    }

    public void update(ParentingTeacher teacher) {
        chickParam(teacher);
        teacherDao.update(teacher);

    }

    public static void chickParam(ParentingTeacher teacher){
        //参数验证
        AssertUtil.intIsNotEmpty(teacher.getOffClassNumStart(),"销课人数不能为空");
        AssertUtil.intIsNotEmpty(teacher.getOffClassNumOver(),"销课人数不能为空");
        AssertUtil.intIsNotEmpty(teacher.getClassMoney(),"课时费不能为空");
    }

    public void delete(Integer id) {

        AssertUtil.intIsNotEmpty(id,"请选择目标删除");
        teacherDao.delete(id);


    }

    public List<LbsTeacher> selectForPageLbs() {

        List<LbsTeacher> lbsTeachers = teacherDao.selectForPageLbs();

        return lbsTeachers;
    }


    public void insertForLbs(LbsTeacher teacher) {
        AssertUtil.isNotEmpty(teacher.getLevel(),"等级不能为空");
        AssertUtil.intIsNotEmpty(teacher.getClassMoney(),"课时费不能为空");
        teacherDao.insertForLbs(teacher);

    }

    public LbsTeacher selectForIdLbs(Integer id) {
        AssertUtil.intIsNotEmpty(id,"请选择后再提交！");
        LbsTeacher lbsTeacher= teacherDao.selectForIdLbs(id);
        return lbsTeacher;

    }

    public void update_lbs(LbsTeacher teacher) {
//        chickParam(teacher);
        AssertUtil.isNotEmpty(teacher.getLevel(),"等级不能为空");
        AssertUtil.intIsNotEmpty(teacher.getClassMoney(),"课时费不能为空");
        teacherDao.update_lbs(teacher);

    }

    public void deleteLbs(Integer id) {
        AssertUtil.intIsNotEmpty(id,"请选择目标删除");
        teacherDao.deleteLbs(id);
    }
}
