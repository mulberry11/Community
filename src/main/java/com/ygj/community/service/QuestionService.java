package com.ygj.community.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ygj.community.entity.Question;
import com.ygj.community.mapper.QuestionMapper;
import com.ygj.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 十一
 * @date 2020-03-30 09:21
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    public PageInfo<Question> list(Integer page, Integer size,Integer tid){
        //开始分页
        PageInfo<Question> selectPage = PageHelper.startPage(page, size).doSelectPageInfo(() -> questionMapper.findQuestion(tid));
        return selectPage;
    }

    public Question getById(Integer id) {
        Question question = questionMapper.findByid(id);
        return question;

    }

    /*public Page<Question> list(Integer page, Integer size) {
        Page pghp=new Page();
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount, page, size);
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }
        //sql查询的初始数=每页数据条数*页码-1
        Integer offset = size * (page - 1);
        List<QuestionDTO> questionDTOS = new ArrayList<QuestionDTO>();
        List<Question> questionList = questionMapper.list(offset, size);
        for (Question question :
                questionList) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOS);
        //拿到总条数


        return paginationDTO;
    }*/

    /*public PaginationDTO list(int userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.countByUserId(userId);
        paginationDTO.setPagination(totalCount, page, size);
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }
        //sql查询的初始数=每页数据条数*页码-1
        Integer offset = size * (page - 1);
        List<QuestionDTO> questionDTOS = new ArrayList<QuestionDTO>();
        List<Question> questionList = questionMapper.listByUserId(userId, offset, size);
        for (Question question :
                questionList) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOS);
        //拿到总条数


        return paginationDTO;
    }*/

    /*public QuestionDTO getById(Integer id) {
        Question question = questionMapper.getById(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        User user = userMapper.findById(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }*/

    public void createOrUpdate(Question question) {
        if (question.getId() == null) {
            questionMapper.insert(question);
        } else {
            questionMapper.updateByPrimaryKeySelective(question);
        }
    }
}
