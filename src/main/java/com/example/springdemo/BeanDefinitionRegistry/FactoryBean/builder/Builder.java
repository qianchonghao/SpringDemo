package com.example.springdemo.BeanDefinitionRegistry.FactoryBean.builder;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;

import java.util.Properties;

public interface Builder<T> {
     T doBuild(Properties properties);

     boolean isAccept(String type);
}
