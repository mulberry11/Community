package com.ygj.community.mapper;

import com.ygj.community.entity.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    @Insert("insert into question (title, description, gmt_create, gmt_modify, createor, comment_count, view_count, like_count, tag) values (#{title}, #{description}, #{gmtCreate},#{gmtModify}, #{createor}, #{commentCount},#{viewCount}, #{likeCount}, #{tag})")
    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    @Select("select view_count from question")
    int selectViewCount();

    @Select("select * from question")
    List<Question> list();
}