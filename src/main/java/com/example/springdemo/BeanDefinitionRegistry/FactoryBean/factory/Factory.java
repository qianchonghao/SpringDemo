package com.example.springdemo.BeanDefinitionRegistry.FactoryBean.factory;

import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.builder.AbstractBuilder;
import org.springframework.core.env.Environment;

public interface Factory<T> {
    T build(Environment environment);

    String getPrefix();

    Class<? extends AbstractBuilder> getBuilderClass();

}
