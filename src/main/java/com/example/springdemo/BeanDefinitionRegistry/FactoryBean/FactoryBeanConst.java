package com.example.springdemo.BeanDefinitionRegistry.FactoryBean;

import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.factoryBeanImpl.DataSourceFactoryBean;
import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.factoryBeanImpl.SearchClientFactoryBean;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;


public class FactoryBeanConst {

    private static String DATA_SOURCE_FACTORY_BEAN = "com.example.springdemo.BeanDefinitionRegistry.FactoryBean.factoryBeanImpl.DataSourceFactoryBean";
    private static String SEARCH_CLIENT_FACTORY_BEAN = "com.example.springdemo.BeanDefinitionRegistry.FactoryBean.factoryBeanImpl.SearchClientFactoryBean";
    public static ImmutableSet<String> factoryBeans = ImmutableSet.of(
            DATA_SOURCE_FACTORY_BEAN,
            SEARCH_CLIENT_FACTORY_BEAN
    );


}
