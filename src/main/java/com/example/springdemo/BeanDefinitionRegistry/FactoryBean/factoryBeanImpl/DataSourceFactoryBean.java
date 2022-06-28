package com.example.springdemo.BeanDefinitionRegistry.FactoryBean.factoryBeanImpl;

import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.builder.Builder;
import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.model.DataSource;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;

//@CustomImport(prefix = "dataSource")
public class DataSourceFactoryBean implements FactoryBean<DataSource>{
    public static String PREFIX = "dataSource";
    private DataSource dataSource;




    @Override
    public DataSource getObject() throws Exception {
        return dataSource;
    }

    @Override
    public Class<?> getObjectType() {
        return DataSource.class;
    }


}
