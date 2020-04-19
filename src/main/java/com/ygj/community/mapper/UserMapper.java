package com.ygj.community.mapper;

import com.ygj.community.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @author 十一
 * @date 2020-03-24 19:16
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modify,avatar_url) values(#{name},#{account_id},#{token},#{gmt_create},#{gmt_modify},#{avatar_url})")
    public void insterUser(@Param("user") User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id=#{id}")
    User findById(@Param("id") Integer creator);

    @Select("select * from user where account_id=#{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("update user set name=#{user.name},token=#{user.token},gmt_modify=#{user.gmtModify},avatar_url=#{user.avatarUrl} where id=#{user.id}")
    void update(@Param("user") User user);
}
