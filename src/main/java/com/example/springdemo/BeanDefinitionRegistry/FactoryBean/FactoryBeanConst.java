package com.example.springdemo.BeanDefinitionRegistry.FactoryBean;

import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.FactoryBeanImpl.DataSourceFactoryBean;
import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.FactoryBeanImpl.SearchClientFactoryBean;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;


public class FactoryBeanConst {
    public static String DATASOURCE_PREFIX = "dataSource";
    public static String SEARCH_CLIENT_PREFIX = "searchClient";

    public static ImmutableMap<Class,String> CLASS_2_PREFIX = ImmutableMap.of(
            DataSourceFactoryBean.class,DATASOURCE_PREFIX,
            SearchClientFactoryBean.class,SEARCH_CLIENT_PREFIX
    );

    private static String DATA_SOURCE_FACTORY_BEAN = "com.example.springdemo.BeanDefinitionRegistry.FactoryBean.FactoryBeanImpl.DataSourceFactoryBean";
    private static String SEARCH_CLIENT_FACTORY_BEAN = "com.example.springdemo.BeanDefinitionRegistry.FactoryBean.FactoryBeanImpl.SearchClientFactoryBean";
    public static ImmutableSet<String> factoryBeans = ImmutableSet.of(
            DATA_SOURCE_FACTORY_BEAN,
            SEARCH_CLIENT_FACTORY_BEAN
    );

}
