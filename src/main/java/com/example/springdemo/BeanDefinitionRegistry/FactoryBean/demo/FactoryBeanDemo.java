package com.example.springdemo.BeanDefinitionRegistry.FactoryBean.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class FactoryBeanDemo implements ApplicationContextAware , InitializingBean {
    private ApplicationContext context;
    @Autowired
    private IFactoryBean iFactoryBean;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context= applicationContext;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        // @leimo
        // 1. context.getBean(factoryName) 返回是getObject() 注入到context内的bean
        // 2. context.getBean(&factoryName) return 工厂bean自身
//
        IFactoryBean beanFromGetObject = (IFactoryBean) context.getBean("IFactoryBean");
        IFactoryBean beanFromConstructor = (IFactoryBean) context.getBean("&IFactoryBean");
        beanFromGetObject.getMessage();
        beanFromConstructor.getMessage();
        System.out.println(beanFromGetObject == beanFromConstructor);
//
//        IFactoryBean factoryBean1 = iFactoryBean.getObject();
//        IFactoryBean factoryBean2 = iFactoryBean.getObject();
//        factoryBean1.getMessage();
//        factoryBean2.getMessage();
        // test2 :
        // 1. autowired 注入FactoryBean，而非 FactoryBean.getObject()对象
        // 2. 可通过 FactoryBean.getObject()方法，获取非工厂Bean
//        iFactoryBean.getMessage();
    }
}
