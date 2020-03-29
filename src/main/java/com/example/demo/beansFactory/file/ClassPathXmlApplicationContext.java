package com.example.demo.beansFactory.file;


import com.example.demo.beansFactory.BeansFactory;
import com.example.demo.beansFactory.model.BeanDefinition;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <>
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


    private void loadBeanDefinitions(String configLocation) {
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
