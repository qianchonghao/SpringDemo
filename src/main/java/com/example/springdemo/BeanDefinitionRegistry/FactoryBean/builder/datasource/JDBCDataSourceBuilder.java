package com.example.springdemo.BeanDefinitionRegistry.FactoryBean.builder.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.example.springdemo.BeanDefinitionRegistry.FactoryBean.builder.DataSourceBuilder;
import org.apache.commons.lang3.StringUtils;

import javax.sql.DataSource;
import java.util.Properties;

public class JDBCDataSourceBuilder extends DataSourceBuilder {
    private static String TYPE="JDBC";

    private static String URL="url";
    private static String USER_NAME="username";
    private static String PASS_WORD="password";
    private static String INIT_CONNECTION_SQLS="initConnectionSqls";
    private static String MAX_WAIT = "maxWait";

    @Override
    public DataSource doBuild(Properties properties){
//        properties.get(URL);
//        properties.get(USER_NAME);
//        properties.get(PASS_WORD);
//        properties.get(INIT_CONNECTION_SQLS);
        if (StringUtils.isEmpty((String)properties.get(MAX_WAIT))) {
            properties.setProperty(MAX_WAIT,"5000");
        }

        DruidDataSource  dataSource = null;
        try {
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
            dataSource.init();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(">>>>>>>>>>>>> JDBC datasource init");
        return dataSource;
    }

    @Override
    public boolean isAccept(String type) {
        return TYPE.equals(type);
    }
}
