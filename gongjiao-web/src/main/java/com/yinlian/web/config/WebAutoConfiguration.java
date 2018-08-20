package com.yinlian.web.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Desc:
 * Author: Created by wangjinshan on 2018/08/20.
 * Mail: 
 */
@Configuration
@ComponentScan("com.yinlian.web")
public class WebAutoConfiguration extends WebMvcConfigurerAdapter {
    

}
