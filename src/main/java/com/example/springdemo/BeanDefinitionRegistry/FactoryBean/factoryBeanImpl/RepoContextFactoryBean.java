package com.example.springdemo.BeanDefinitionRegistry.FactoryBean.factoryBeanImpl;

import com.alibaba.fastjson.JSON;
import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.factory.DataSourceFactory;
import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.model.RepoContext;
import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.model.SearchClient;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import javax.sql.DataSource;

import javax.sql.DataSource;
import java.util.Properties;

public class RepoContextFactoryBean implements FactoryBean<RepoContext> , ApplicationContextAware, InitializingBean, EnvironmentAware {
    private ApplicationContext context;
    private Environment environment;
    private RepoContext repoContext;
    private Properties properties;


    public RepoContextFactoryBean(Properties properties) {
        this.properties = properties;
    }

    @Override
    public RepoContext getObject() throws Exception {
        return repoContext;
    }

    @Override
    public Class<?> getObjectType() {
        return RepoContext.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>> RepoContextFactoryBean constructor args: "+JSON.toJSONString(properties));

        repoContext = build();
    }

    private RepoContext build() {

        DataSource dataSource = DataSourceFactory.create().build(environment);
        RepoContext repoContext = new RepoContext();
        repoContext.setDataSource(dataSource);
        return repoContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment=environment;
    }
}
