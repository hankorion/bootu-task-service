package com.bootu.order.user.mapper;

import com.bootu.thrift.user.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select id, username, password, realname, mobile, email from bootu_task_user where id=#{id}")
    UserInfo getUserById(@Param("id") int id);

    @Select("select id, username, password, realname, mobile, email from bootu_task_user where username=#{username}")
    UserInfo getUSerByName(@Param("username") String username);

    @Insert("insert into bootu_task_user (username, password, realname, mobile, email) values (#{userInfo.username},#{userInfo.password},#{userInfo.realname},#{userInfo.mobile},#{userInfo.email})")
    void registerUser(@Param("userInfo") UserInfo userInfo);
}
