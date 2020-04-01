package com.example.demo.beansFactory.file;


import com.example.demo.beansFactory.BeansFactory;
import com.example.demo.beansFactory.model.BeanDefinition;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <当创建的对象是一个大的工程的时候>
 * DI 容器的底层就是基于工厂的模式
 *
 * @author fangyang
 * @create 2020-03-29
 * @since 1.0.0
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {

    private BeansFactory beansFactory;
    private BeanConfigParser beanConfigParser;

    public ClassPathXmlApplicationContext(String configLocation) {
        this.beansFactory = new BeansFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }


    /**
     * 初始化的时候需要加载的配置文件.
     *
     * @param configLocation the configLocation
     */
    private void loadBeanDefinitions(String configLocation) {

        // 商家的数据处理.
        try (InputStream in = this.getClass().getResourceAsStream("/" + configLocation)) {
            if (in == null) {
                throw new RuntimeException("Can not find config file: " + configLocation);
            }
            List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
            beansFactory.addBeanDefinitions(beanDefinitions);
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: log error
        }

    }


    @Override
    public Object getBean(String beanId) {
        return beansFactory.getBean(beanId);
    }
}
