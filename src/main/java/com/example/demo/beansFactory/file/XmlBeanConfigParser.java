package com.example.demo.beansFactory.file;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <>
 *
 * @author fangyang
 * @create 2020-03-29
 * @since 1.0.0
 */
public class XmlBeanConfigParser implements BeanConfigParser {
    @Override
    public List parse(InputStream inputStream) {
        String content = null;
        // TODO:...


        return parse(content);
    }

    @Override
    public List parse(String configContent) {

        List beanDefinitions = new ArrayList<>();
        // TODO:...


        return beanDefinitions;
    }
}
