package com.example.springdemo.BeanDefinitionRegistry.FactoryBean.factoryBeanImpl;

import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.builder.Builder;
import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.model.SearchClient;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;


//@CustomImport(prefix = "searchClient")
public class SearchClientFactoryBean implements FactoryBean<SearchClient>{
    private SearchClient searchClient;

    public static String PREFIX = "searchClient";

// @leimo todo:
//  searchFactoryBean：实现spring容器的注入)
    // searchClient : 存在 os和es两种Client实现
//  Factory(存在多种实现)

//  Builder

    public void setRepoContext(SearchClient searchClient) {
        this.searchClient = searchClient;
    }

    @Override
    public SearchClient getObject() throws Exception {
        return searchClient;
    }

    @Override
    public Class<?> getObjectType() {
        return SearchClient.class;
    }

}
