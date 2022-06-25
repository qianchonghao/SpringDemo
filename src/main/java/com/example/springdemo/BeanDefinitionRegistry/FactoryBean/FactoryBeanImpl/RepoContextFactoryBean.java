package com.example.springdemo.BeanDefinitionRegistry.FactoryBean.FactoryBeanImpl;

import com.alibaba.fastjson.JSON;
import com.example.springdemo.BeanDefinitionRegistry.Model.DataSource;
import com.example.springdemo.BeanDefinitionRegistry.Model.RepoContext;
import com.example.springdemo.BeanDefinitionRegistry.Model.SearchClient;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import static com.example.springdemo.BeanDefinitionRegistry.FactoryBean.FactoryBeanConst.CLASS_2_PREFIX;
import java.util.Properties;
public class RepoContextFactoryBean implements FactoryBean<RepoContext> , ApplicationContextAware, InitializingBean, EnvironmentAware {
    private ApplicationContext context;
    private Environment environment;
    private RepoContext repoContext;
    private Properties properties;

    private DataSource dataSource;
    private SearchClient searchClient;

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
        CLASS_2_PREFIX.get(DataSourceFactoryBean.class);
        CLASS_2_PREFIX.get(SearchClientFactoryBean.class);

        return null;
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
