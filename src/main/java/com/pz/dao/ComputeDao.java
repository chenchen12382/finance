package com.pz.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.base.BaseQuery;
import com.pz.model.Compute;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by Administrator on 2018/3/8.
 */
public interface ComputeDao {

    @Insert("insert into t_compute (dx,gwgz,jxgz,bmf,tcjj,bbj,ksf,bfgz,ft,jt,bsj,kk,qtkk,gzze,name,work,center,is_valid,create_date,update_date ) values (#{dx},#{gwgz},#{jxgz},#{bmf},#{tcjj}," +
            "#{bbj},#{ksf},#{bfgz},#{ft},#{jt},#{bsj},#{kk},#{qtkk},#{gzze},#{name},#{work},#{center},1,now(),now())")
    void insert(Compute compute);


    @Select("select * from t_compute where is_valid=1 ORDER BY create_date DESC ")
    PageList<Compute> selectForPage(BaseQuery query, PageBounds pageBounds);


    @Update("update t_compute set is_valid=0 where id=#{id}")
    void delete(@Param("id") Integer id);
}
