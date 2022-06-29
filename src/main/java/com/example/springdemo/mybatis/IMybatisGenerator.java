package com.example.springdemo.mybatis;

import com.google.common.collect.Lists;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 用于生产MBG的代码
 * Created by macro on 2018/4/26.
 */
public class IMybatisGenerator {
//        public static void test(String[] args) throws Exception {
//        //MBG 执行过程中的警告信息
//        List<String> warnings = new ArrayList<String>();
//        //当生成的代码重复时，覆盖原代码
//        boolean overwrite = true;
//        // 1. 指定MBG数据源
//        InputStream is = Thread.currentThread().getContextClassLoader().
//                getResourceAsStream("/generatorConfig.xml");
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(is);
//        is.close();
//
//        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//        //创建 MBG
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//        //执行生成代码
//        myBatisGenerator.generate(null);
//        //输出警告信息
//        for (String warning : warnings) {
//            System.out.println(warning);
//        }
//    }

    public static void main(String[] args) throws Exception{
        // 1. 获取mybatis generator的配置数据源
        // @leimo warning:
        InputStream is = IMybatisGenerator.class.getClass().getResource("/generatorConfig.xml").openStream();


        /**
         *         generator.xml的作用：
         *          1. 指定生成路径 mapper.xml, mapper, DTO的路径
         *          2. 指定数据源链接的配置文件（jdbc.properties）
         *              jdbc.properties 指定具体的
         */
        // 2. ConfigurationParser 解析 mybatis generator的配置文件
        List<String> warnings = Lists.newArrayList();
        ConfigurationParser parser = new ConfigurationParser(warnings);
        Configuration configuration = parser.parseConfiguration(is);

        // 3. MBG根据 mbConfig 生成
        // new DefaultShellCallback(true) 定义是否覆写
        MyBatisGenerator MBG = new MyBatisGenerator(configuration, new DefaultShellCallback(true), warnings);
        MBG.generate(null);

        for(String warning:warnings){
            System.out.println(">>>>>>>> MBG waring: " + warning + "\n");
        }
    }
}
