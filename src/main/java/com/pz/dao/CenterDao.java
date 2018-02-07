package com.pz.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.base.BaseQuery;
import com.pz.model.Center;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by Administrator on 2018/2/6.
 */
public interface CenterDao {


    PageList<Center> selectForPage(BaseQuery query, PageBounds pageBounds);

    @Insert("insert into t_center (center,district,is_valid,create_date,update_date) values (#{center},#{district},1,now(),now() )")
    void insert(Center center);

    @Select("select * from t_center where id=#{id} and is_valid=1")
    Center selectForId(@Param("id") Integer id);

    @Update("update t_center set is_valid= 0 where id=#{id}")
    void delete(@Param("id") Integer id);

    @Update("update t_center set center=#{center},district=#{district},update_date=now() where id=#{id}")
    void update(Center center);
}
