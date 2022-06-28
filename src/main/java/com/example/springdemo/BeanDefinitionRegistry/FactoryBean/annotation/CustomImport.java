package com.example.springdemo.BeanDefinitionRegistry.FactoryBean.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomImport {
    String className() default "default_name";
    String prefix();
}
