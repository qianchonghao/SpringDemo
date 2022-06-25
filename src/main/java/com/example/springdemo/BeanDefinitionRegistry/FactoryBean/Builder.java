package com.example.springdemo.BeanDefinitionRegistry.FactoryBean;

import org.springframework.core.env.Environment;

import java.util.Properties;

public interface Builder {
     void init(Environment environment);
}
