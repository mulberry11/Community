package com.ygj.community.service;

import com.ygj.community.dto.QuestionDTO;
import com.ygj.community.entity.Question;
import com.ygj.community.entity.User;
import com.ygj.community.mapper.QuestionMapper;
import com.ygj.community.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 十一
 * @date 2020-03-30 09:21
 */
@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;
    public List<QuestionDTO> list() {
        List<QuestionDTO> questionDTOS=new ArrayList<QuestionDTO>();
        List<Question> questionList = questionMapper.list();
        for (Question question :
                questionList) {
            User user=userMapper.findById(question.getCreateor());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        return questionDTOS;
    }
}
