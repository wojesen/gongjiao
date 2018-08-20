package com.yinlian.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yinlian.user.model.User;
import com.yinlian.user.service.UserService;




/**
 * Created by wangjinshan on 2018/08/20.
 */
@RestController
@RequestMapping("/user")  
public class UserController {

	@Autowired
    private UserService userService;
	
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public User list() {
        System.out.println("212122");
        User user = userService.queryList("21");
        return user;
    }


   
}