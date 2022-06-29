package com.example.springdemo.mybatis;

import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.factory.DataSourceFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 *      @leimo 1. 需要添加 mybatis的 依赖
 *      如下：
 *         <dependency>
 *             <groupId>org.mybatis</groupId>
 *             <artifactId>mybatis-spring</artifactId>
 *             <version>1.3.2</version>
 *         </dependency>
  */

@Configuration
@MapperScan(value = "com.example.springdemo.mybatis.mapper",sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfiguration {

    @Bean("datasource")
    public DataSource getDataSource(){
        return null;
    }


}

