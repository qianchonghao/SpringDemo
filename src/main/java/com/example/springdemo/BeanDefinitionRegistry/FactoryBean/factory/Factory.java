package com.example.springdemo.BeanDefinitionRegistry.FactoryBean.factory;

import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.builder.AbstractBuilder;
import org.springframework.core.env.Environment;

import java.util.Properties;

public interface Factory<T> {
    T build(Environment environment);
//    T build(Properties properties);

    String getPrefix();

    Class<? extends AbstractBuilder> getBuilderClass();

}
