package com.example.springdemo.BeanDefinitionRegistry.FactoryBean.factory;

import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.builder.AbstractBuilder;
import org.springframework.core.env.Environment;

import java.util.Iterator;
import java.util.ServiceLoader;

public abstract class AbstractFactory<T> implements Factory<T> {

    @Override
    public T build(Environment environment) {
        Class<? extends AbstractBuilder> builderClass = getBuilderClass();
        String prefix = getPrefix();

        ServiceLoader<? extends AbstractBuilder> builders = ServiceLoader.load(builderClass);
        Iterator<? extends AbstractBuilder> iterable = builders.iterator();
        T res = null;

        while (iterable.hasNext()) {
            AbstractBuilder<T> builder = iterable.next();
            res = builder.build(environment, prefix);
            if (res != null) {
                return res;
            }
        }

       return null;
    }

}
