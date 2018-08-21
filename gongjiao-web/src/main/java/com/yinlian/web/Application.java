package com.yinlian.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


@SpringBootApplication
@Slf4j
public class Application implements ApplicationContextAware {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		for(String name : applicationContext.getBeanDefinitionNames()){
			log.info(name);
		}
	}
}
