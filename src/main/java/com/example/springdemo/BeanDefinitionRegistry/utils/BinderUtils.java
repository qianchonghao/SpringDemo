package com.example.springdemo.BeanDefinitionRegistry.utils;

import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.ConfigurableEnvironment;

public class BinderUtils {


    public static <T> T  binderBind(ConfigurableEnvironment environment, String prefix, Class<T> type){
        // 1. 根据environment 创建binder对象
        Binder binder = Binder.get(environment);
        // 2. 根据classType 创建bindable对象
        Bindable<T> binderAble = Bindable.of(type);
        // 3.  binderAble 关联 properties类, PREFIX指定前缀
        return binder.bind(prefix,binderAble).orElse(null);
    }
}
