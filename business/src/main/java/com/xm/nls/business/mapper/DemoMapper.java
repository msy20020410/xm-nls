package com.xm.nls.business.mapper;

import com.xm.nls.business.model.entity.Demo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Demo record);

    int insertSelective(Demo record);

    Demo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Demo record);

    int updateByPrimaryKey(Demo record);

    List<Demo> selectByNameOrderByAge(@Param("name")String name);



}