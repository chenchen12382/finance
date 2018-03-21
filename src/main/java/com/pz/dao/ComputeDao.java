package com.pz.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.dto.ComputeFormQuery;
import com.pz.model.Compute;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/3/8.
 */
public interface ComputeDao {

    @Insert("insert into t_compute (sfz,cqts,yeybt,ccbt,jxxs,cjkk,sjkk,bjkk,kgkk,cdkk,yfgz,grsbhj,grgjj,grsds,qysbhj,qygjj," +
            " dx,gwgz,jxgz,bmf,tcjj,bbj,ksf,bfgz,ft,jt,bsj,kk,qtkk,gzze,name,work,center,is_valid,create_date,update_date,gzbc ) values " +
            " (#{sfz},#{cqts},#{yeybt},#{ccbt},#{jxxs},#{cjkk},#{sjkk},#{bjkk},#{kgkk},#{cdkk},#{yfgz},#{grsbhj},#{grgjj},#{grsds}," +
            " #{qysbhj},#{qygjj},#{dx},#{gwgz},#{jxgz},#{bmf},#{tcjj}," +
            "#{bbj},#{ksf},#{bfgz},#{ft},#{jt},#{bsj},#{kk},#{qtkk},#{gzze},#{name},#{work},#{center},1,now(),now(),#{gzbc})")
    void insert(Compute compute);


    PageList<Compute> selectForPage(ComputeFormQuery query, PageBounds pageBounds);


    @Update("update t_compute set is_valid=0 where id=#{id}")
    void delete(@Param("id") Integer id);


    void addAll(List<Compute> computes);

    @Select("select count(1) from t_compute where sfz=#{sfz} and is_valid=1 and create_date BETWEEN #{start} AND #{over} ")
    Integer findBySfz(@Param("sfz") Integer sfz, @Param("start") Date start, @Param("over") Date over);

    @Update("update t_compute set sfz=#{sfz},cqts=#{cqts},yeybt=#{yeybt},ccbt=#{ccbt},jxxs=#{jxxs},cjkk=#{cjkk},sjkk=#{sjkk},bjkk=#{bjkk},kgkk=#{kgkk},cdkk=#{cdkk},yfgz=#{yfgz}, " +
            " grsbhj=#{grsbhj},grgjj=#{grgjj},grsds=#{grsds},qysbhj=#{qysbhj},qygjj=#{qygjj}, " +
            " dx=#{dx},gwgz=#{gwgz},jxgz=#{jxgz},bmf=#{bmf},tcjj=#{tcjj},bbj=#{bbj},ksf=#{ksf},bfgz=#{bfgz},ft=#{ft},jt=#{jt},bsj=#{bsj},kk=#{kk},qtkk=#{qtkk}, " +
            " gzze=#{gzze},name=#{name},work=#{work},center=#{center},gzbc=#{gzbc} where sfz=#{sfz} and is_valid=1 and create_date BETWEEN #{start} AND #{over} ")
    void update(Compute compute);
}
