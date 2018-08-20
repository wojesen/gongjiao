package com.yinlian.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yinlian.pay.service.InstanceService;



/**
 * Created by wangjinshan on 2018/08/20.
 */
@RestController
@RequestMapping("/test2")  
public class InstanceController {

	@Autowired
    private InstanceService instanceService;
	
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        System.out.println("212122");
        instanceService.queryList("21");
        return "hello";
    }


   
}
