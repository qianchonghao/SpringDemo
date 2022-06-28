package com.example.springdemo.RunListener;

import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.factoryBeanImpl.RepoContextFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;

public class IApplicationRunListener implements SpringApplicationRunListener {
    @Autowired
    private RepoContextFactoryBean factoryBean;

    public IApplicationRunListener(SpringApplication application,String[] args) {
        System.out.println("IApplicationRunListener init");
    }
}
