package com.example.springdemo.BeanDefinitionRegistry.FactoryBean.builder;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;
import java.util.Properties;

// todo : 根据 factoryClass 获取 实现的FactoryImpl
public abstract class AbstractBuilder<T> implements Builder<T> {

     Properties getConfig(Environment environment, String prefix){
         // @leimo todo : binder不支持 prefix的驼峰规则。
        Properties res = Binder.get(environment).bind(prefix, Properties.class).orElse(new Properties());
        return res;
    }

     public T build(Environment environment, String prefix) {
        Properties properties = getConfig(environment, prefix);

        String type = (String) properties.get("type");
        if (!isAccept(type)) {
            System.out.println(">>>>>>>>> required type is " + type);
            return null;
        }
        return doBuild(properties);
    }

//    public T build(Properties properties, String prefix) {
//        Properties properties = getConfig(environment, prefix);
//
//        String type = (String) properties.get("type");
//        if (!isAccept(type)) {
//            System.out.println(">>>>>>>>> required type is " + type);
//            return null;
//        }
//        return doBuild(properties);
//    }


}
