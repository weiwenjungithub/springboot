package com.wwj.springboot.springbootmybatis.mapper;

import com.wwj.springboot.springbootmybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author weiwenjun
 * @since 2019/5/24
 */
@Mapper
public interface CityMapper {

    @Select("SELECT * FROM user  limit 1")
    User findByState(@Param("state") String state);

}