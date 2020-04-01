package com.example.demo.beansFactory.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.context.support.BeanDefinitionDsl;

import java.util.ArrayList;
import java.util.List;

/**
 * <>
 *
 * @author fangyang
 * @create 2020-03-29
 * @since 1.0.0
 */
@Data
public class BeanDefinition {

    private String id;
    private String className;
    private List constructorArgs = new ArrayList<>();
    private BeanDefinitionDsl.Scope scope = BeanDefinitionDsl.Scope.SINGLETON;
    private boolean lazyInit = false;


    /**
     * 判断懒加载的方式. 面向函数编程
     *
     * @return the Boolean
     */
    public boolean isSingleton() {
        return scope.equals(BeanDefinitionDsl.Scope.SINGLETON);
    }

    @Getter
    public static enum Scope {
        SINGLETON, PROTOTYPE
    }


    @Data
    public static class ConstructorArg {
        private Boolean isRef;
        private Class type;
        private Object arg;
    }

}
