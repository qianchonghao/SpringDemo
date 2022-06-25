package com.example.springdemo.BeanDefinitionRegistry.FactoryBean.FactoryBeanImpl;

import com.example.springdemo.BeanDefinitionRegistry.CustomImport;
import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.Builder;
import com.example.springdemo.BeanDefinitionRegistry.Model.DataSource;
import com.example.springdemo.BeanDefinitionRegistry.Model.RepoContext;
import com.example.springdemo.BeanDefinitionRegistry.Model.SearchClient;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;


//@CustomImport(prefix = "searchClient")
public class SearchClientFactoryBean implements FactoryBean<SearchClient> , Builder {
    private SearchClient searchClient;

    public static String PREFIX = "searchClient";

// @leimo todo:
//  searchFactoryBean：实现spring容器的注入)
    // searchClient : 存在 os和es两种Client实现
//  Factory(存在多种实现)

//  Builder


    @Override
    public void init(Environment environment) {
        searchClient = Binder.get(environment).bind(PREFIX,SearchClient.class).orElse(new SearchClient());
    }

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
