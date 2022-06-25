package com.example.springdemo.BeanDefinitionRegistry;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomImport {
    String className() default "default_name";
    String prefix();
}
