package com.itguigu.controller;

import com.itguigu.pojo.User;
import com.itguigu.service.UserService;
import com.itguigu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
@MapperScan("com.itguigu.dao")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询所有用户信息
     * @return
     */
    @RequestMapping(path = "/findAll")
    @ResponseBody
    public Result findAll() {
        List<User> users = userService.findAll();
        return Result.ok(users);
    }
}

