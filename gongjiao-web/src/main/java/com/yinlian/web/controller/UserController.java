package com.yinlian.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yinlian.core.common.Response;
import com.yinlian.user.dto.UserInfoDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yinlian.user.service.UserInfoService;




/**
 * Created by wangjinshan on 2018/08/20.
 */
@RestController
@RequestMapping("/user")  
public class UserController {

	@Reference(version = "1.0.0", timeout = 10000)
    private UserInfoService userService;
	
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list() {
        System.out.println("212122");
        Response<UserInfoDto> user = userService.getUserInfo("21");
        System.out.println(user.getResult());
    }
   
}
