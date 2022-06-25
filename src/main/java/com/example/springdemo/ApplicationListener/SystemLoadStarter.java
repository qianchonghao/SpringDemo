package com.example.springdemo.ApplicationListener;

import com.example.springdemo.utils.PropertiesUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SystemLoadStarter implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        PropertiesUtils.getSpringFactories();
    }
}
