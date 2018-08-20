package com.yinlian.web.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Desc:
 * Date: 16/2/16 22:29
 * Author: Grancy
 * Mail: guork@terminus.io
 */
@Configuration
@ComponentScan("com.yinlian.web")
public class WebAutoConfiguration extends WebMvcConfigurerAdapter {
    

}
