package com.ygj.community;

import com.ygj.community.entity.Question;
import com.ygj.community.mapper.QuestionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommunityApplicationTests {
    @Autowired
    private QuestionMapper questionMapper;

    @Test
    void contextLoads() {
        for (Question question:questionMapper.findQuestion(null)) {
            System.out.println(question);
        }

    }

}
