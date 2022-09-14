package com.anno;

import org.junit.Test;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * https://www.pdai.tech/md/java/basic/java-basic-x-annotation.html#java-%E5%9F%BA%E7%A1%80---%E6%B3%A8%E8%A7%A3%E6%9C%BA%E5%88%B6%E8%AF%A6%E8%A7%A3
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/9/18 10:30 上午
 * FileName: TestDocAnnotation
 * Description: com.anno
 * Documented注解的作用是：描述在使用 javadoc 工具为类生成帮助文档时是否要保留其注解信息。
 *
 * @Target({ElementType.FIELD, ElementType.METHOD}):作用于方法和变量上
 */


@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface TestDocAnnotation {
    public String value() default "default";
}

class A {
    @TestDocAnnotation("dsdasd")
    public void test1() {

    }

    @Test
    @TestDocAnnotation("test2")
    public void test2() {

    }
}


class MainTest {
    public static void main(String[] args) {
        Method[] methods = A.class.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(TestDocAnnotation.class)) {
                Annotation[] annotations = method.getAnnotations();
                for (Annotation annotation : annotations) {
                    System.out.println(annotation);
                }
            }
        }
    }
}