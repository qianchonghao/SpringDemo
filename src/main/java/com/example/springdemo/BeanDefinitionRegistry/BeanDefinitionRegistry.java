package com.example.springdemo.BeanDefinitionRegistry;

import com.alibaba.fastjson.JSONObject;

import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.FactoryBeanImpl.RepoContextFactoryBean;
import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.FactoryBeanConst;
import com.example.springdemo.BeanDefinitionRegistry.Model.DataSource;
import com.example.springdemo.BeanDefinitionRegistry.utils.BinderUtils;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;

import java.util.Properties;

@Configuration(proxyBeanMethods = false)
public class BeanDefinitionRegistry implements EnvironmentAware, ImportBeanDefinitionRegistrar {
    private ConfigurableEnvironment environment;
    private static String JDBC_PREFIX = "jdbc.datasource";

    private static String PREFIX = "demo";
    private static String SEPARATOR = ".";
    private static String FACTORY_BEAN_NAME_LIST = "factoryBeans";

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = (ConfigurableEnvironment) environment;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, org.springframework.beans.factory.support.BeanDefinitionRegistry registry) {
        System.out.println(">>>>>>>>>> registry");

        //  @leimo note Binder.get(environment).bind(PREFIX,DataSource.class).orElse(null); 等价 @ConfigurationProperties(prefix = PREFIX)
        // 都旨在实现： 配置文件 -> Java对象
        // 区别在于 @ConfigurationProperties的执行顺序 在 Binder之后。因为那时SpringBean已经注入Context（Spring容器）
        DataSource dataSource = BinderUtils.binderBind(environment,JDBC_PREFIX, DataSource.class);
        System.out.println(JSONObject.toJSONString(dataSource));


        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 以上是 demo内容

        for (String className : FactoryBeanConst.factoryBeans) {
            // 1. 遍历所有 factoryBeans，并将对应beanDefinition 注册到 Spring context
            // @leimo todo： 此处通过 Const定义 那些类的beanDefinition需要添加。
            // @leimo todo: 其实还有注解实现，扫描指定包路径下的class with specific annotation,获取注解内value。

            try {
                Class clz = ClassUtils.forName(className,Thread.currentThread().getContextClassLoader());
                register(registry,clz);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // 2. 注册 RepoContextFactoryBean, 所有的FactoryBean.getObject() 源于 RepoContext
        Properties properties = Binder.get(environment).bind(PREFIX, Properties.class).orElse(null);
        registerRepoContextFactoryBean(registry, properties);
    }

    private void registerRepoContextFactoryBean(org.springframework.beans.factory.support.BeanDefinitionRegistry registry, Properties properties) {
        String beanName = getBeanName(RepoContextFactoryBean.class);
        BeanDefinition bd = BeanDefinitionBuilder.genericBeanDefinition(RepoContextFactoryBean.class).
                setRole(BeanDefinition.ROLE_INFRASTRUCTURE).
                addConstructorArgValue(properties).
//                addPropertyReference(beanName, clz.getName()).
        getBeanDefinition();
        registry.registerBeanDefinition(beanName, bd);
    }

    private <T> void register(org.springframework.beans.factory.support.BeanDefinitionRegistry registry, Class<T> clz) {
        String beanName = getBeanName(clz);
        BeanDefinition bd = BeanDefinitionBuilder.genericBeanDefinition(clz).
                setRole(BeanDefinition.ROLE_INFRASTRUCTURE).
//                addPropertyReference(beanName, clz.getName()).
                getBeanDefinition();
        registry.registerBeanDefinition(beanName, bd);
    }

    private String getBeanName(Class clz){
        StringBuilder stringBuilder = new StringBuilder();
        return StringUtils.join(Lists.newArrayList(PREFIX,clz.getName()),SEPARATOR);
    }

    public static String getPrefix(String prefix){
        return PREFIX + "." + prefix;
    }
}
