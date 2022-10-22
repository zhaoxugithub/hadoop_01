package com.old.test;

import com.old.reflect.Person;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.StringJoiner;

/**
 * Copyright (C), 2017-2022, 赵旭
 * Author: 11931
 * Date: 2022/4/1 11:18
 * FileName: SimpleTest
 * Description: com.test
 */
public class SimpleTest {


    @Test
    public void test01() {

        String[] names = {"name", "Alice", "Grace"};
        //设置分隔符一斤
        StringJoiner sj = new StringJoiner(",", "start", "end");
        for (String name : names) {
            sj.add(name);
        }

        System.out.println(sj.toString());
    }

    @Test
    public void test02() {
        String[] names = {"name", "Alice", "Grace"};
        StringBuilder sj = new StringBuilder();
        for (String name : names) {
            sj.append(name);
        }

        System.out.println(sj.toString());
    }

    @Test
    public void test3() {
        String[] names = {"Bob", "Alice", "Grace"};
        // 可以用String中的join方法实现拼接
        String s = String.join(", ", names);
        System.out.println(s);
    }

    @Test
    public void test04() {
        int i = 100;
        Integer integer = Integer.valueOf(i);
        Integer integer1 = Integer.valueOf("10000");
        int i1 = integer1.intValue();
        int i2 = Integer.parseInt("100000");
        long l = integer1.longValue();
    }

    @Test
    public void test05() throws IntrospectionException {

        //要枚举一个JavaBean的所有属性，可以直接使用Java核心库提供的Introspector：
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            System.out.println(propertyDescriptor.getName());
            System.out.println(propertyDescriptor.getReadMethod());
            System.out.println(propertyDescriptor.getWriteMethod());
        }

    }
}
