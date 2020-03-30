package com.ygj.community.mapper;

import com.ygj.community.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 十一
 * @date 2020-03-24 19:16
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modify,avatar_url) values(#{name},#{account_id},#{token},#{gmt_create},#{gmt_modify},#{avatar_url})")
    public void insterUser(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id=#{id}")
    User findById(@Param("id") Integer createor);
}
