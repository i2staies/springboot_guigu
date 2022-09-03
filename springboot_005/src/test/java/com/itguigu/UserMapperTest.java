package com.itguigu;

import com.itguigu.dao.UserMapper;
import com.itguigu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * 1.	@RunWith(SpringRunner.class)指定Junit核心运行类
 * 2.	@SpringBootTest 指定这是一个Spring Boot的测试类, 运行时会自动加载Spring Boot运行环境
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = "com.itguigu.dao")
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper ;

    @Test
    public void findAll() {
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }

}
