package com.example.springdemo;

import com.example.springdemo.mybatis.mapper.UserMapper;
import com.example.springdemo.mybatis.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@SpringBootTest
public class MapperTest {
    @Autowired
    private UserMapper mapper;

//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        User user= new User();
//        user.setName("wzr");
//        user.setDep("ali");
//        user.setPassword("aaa");
//        mapper.insertSelective(user);
//    }

    @Test
    void insertTest(){
        User user= new User();
        user.setName("wzr");
        user.setDep("ali");
        user.setPassword("aaa");
        int res = mapper.insertSelective(user);
        System.out.println("mapper insert res = "+ res);
    }
}
