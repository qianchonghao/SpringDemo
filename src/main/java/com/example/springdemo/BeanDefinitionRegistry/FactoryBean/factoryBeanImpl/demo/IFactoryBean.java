package com.example.springdemo.BeanDefinitionRegistry.FactoryBean.factoryBeanImpl.demo;

import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.model.DataSource;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class IFactoryBean implements FactoryBean<IFactoryBean> {
    private String message;
    public IFactoryBean() {
       message = ">>>>>>>>> constructor return "+this.hashCode();
    }

    @Override
    public IFactoryBean getObject() throws Exception {
        IFactoryBean iFactoryBean = new IFactoryBean();
        iFactoryBean.setMessage(">>>>>>>>> getObject return: "+this.hashCode());
        return iFactoryBean;
    }

    @Override
    public Class<?> getObjectType() {
        return DataSource.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void getMessage() {
        System.out.println(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
