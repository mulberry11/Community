package com.ygj.community.mapper;

import com.ygj.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 十一
 * @date 2020-03-24 19:16
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByAccountId(String accountId);

    User findByToken(String token);

}