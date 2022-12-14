package com.itguigu.service.impl;

import com.itguigu.dao.UserMapper;
import com.itguigu.pojo.User;
import com.itguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Transactional(readOnly = true ,propagation = Propagation.SUPPORTS)
    public List<User> findAll() {
        //从缓存中查询数据  规定存储用户信息使用string类型进行存储, 存储的key就是userList
        List<User> userList = (List<User>) redisTemplate.boundValueOps("userList").get();
        //如果缓存中没有数据, 查询数据库 , 将查询到的数据放入缓存
        if(userList==null){
            userList = userMapper.selectAll();
            redisTemplate.boundValueOps("userList").set(userList);
            System.out.println("从数据库中查询...");
        }else {
            System.out.println("从缓存中查询.....");
        }
        //如果缓存中有数据, 直接返回
        return userList ;
    }
}
