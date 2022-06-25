package com.example.springdemo.BeanDefinitionRegistry.FactoryBean.FactoryBeanImpl;

import com.example.springdemo.BeanDefinitionRegistry.CustomImport;
import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.Builder;
import com.example.springdemo.BeanDefinitionRegistry.Model.DataSource;
import com.example.springdemo.BeanDefinitionRegistry.Model.RepoContext;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;

import java.util.Properties;

//@CustomImport(prefix = "dataSource")
public class DataSourceFactoryBean implements FactoryBean<DataSource> , Builder {
    public static String PREFIX = "dataSource";
    private DataSource dataSource;



    @Override
    public void init(Environment environment) {
        dataSource = Binder.get(environment).bind(PREFIX,DataSource.class).orElse(new DataSource());
    }

    @Override
    public DataSource getObject() throws Exception {
        return dataSource;
    }

    @Override
    public Class<?> getObjectType() {
        return DataSource.class;
    }


}
