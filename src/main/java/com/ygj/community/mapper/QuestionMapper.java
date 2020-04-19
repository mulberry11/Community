package com.ygj.community.mapper;

import com.ygj.community.dto.QuestionDTO;
import com.ygj.community.entity.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    @Insert("insert into question (title, description, gmt_create, gmt_modify, creator, comment_count, view_count, like_count, tag) values (#{title}, #{description}, #{gmtCreate},#{gmtModify}, #{creator}, #{commentCount},#{viewCount}, #{likeCount}, #{tag})")
    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    @Select("select view_count from question")
    int selectViewCount();

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param("offset") Integer offset,@Param("size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator=#{userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param("userId") int userId, @Param("offset") Integer offset, @Param("size") Integer size);

    @Select("select count(1) from question where creator=#{userId}")
    Integer countByUserId(@Param("userId") int userId);

    @Select("select * from question where id=#{id}")
    Question getById(@Param("id") Integer id);
}