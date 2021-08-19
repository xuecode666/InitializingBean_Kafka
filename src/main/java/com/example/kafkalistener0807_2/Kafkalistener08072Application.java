package com.example.kafkalistener0807_2;

import com.example.kafkalistener0807_2.consumer.KafkaConsumers;
import com.example.kafkalistener0807_2.consumer.SpringContextUtil;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Field;

@SpringBootApplication
public class Kafkalistener08072Application {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(Kafkalistener08072Application.class, args);
        SpringContextUtil.setApplicationContext(run);
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) SpringContextUtil.getApplicationContext();
        // 获取bean工厂并转换为DefaultListableBeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();
        // 通过BeanDefinitionBuilder创建bean定义,创建bean信息
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(KafkaConsumers.class);
        // 设置属性userService,此属性引用已经定义的bean:userService,这里userService已经被spring容器管理了.
//        beanDefinitionBuilder.addPropertyReference("topic", "testService");
        beanDefinitionBuilder.addPropertyValue("topic","helloworld.t,helloworld.s");
        // 注册bean
        defaultListableBeanFactory.registerBeanDefinition("testController", beanDefinitionBuilder.getBeanDefinition());


//        Thread.sleep(1000000);
    }

}
