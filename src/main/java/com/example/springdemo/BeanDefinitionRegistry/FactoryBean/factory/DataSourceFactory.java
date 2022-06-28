package com.example.springdemo.BeanDefinitionRegistry.FactoryBean.factory;

import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.builder.AbstractBuilder;
import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.builder.DataSourceBuilder;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
/** @leimo todo: note!!
    DataSourceFactory 作为 Abstract的实现类

    目的：
    1. 和DataSourceBuilder 做映射， 路由到具体的 datasource 构建流程。
    2. 确定 builderClass， dataSourcePrefix

    @leimo todo: note 2
    静态方法和变量是不能被override
    override是服务于多态。

**/

public class DataSourceFactory extends AbstractFactory<DataSource> implements Factory<DataSource> {
    private static String PREFIX = "datasource";

    @Override
    public String getPrefix() {
        return PREFIX;
    }

    @Override
    public Class<? extends AbstractBuilder> getBuilderClass() {
        return DataSourceBuilder.class;
    }

    public static DataSourceFactory create() {
        return new DataSourceFactory();
    }

}
