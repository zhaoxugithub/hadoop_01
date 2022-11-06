package com.old.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
@SuppressWarnings("all")
public class ClassAPI {

    public static void main(String[] args) throws Exception {

        Class<?> aClass = Class.forName("com.old.reflect.Student");

        // 获取成员变量、包括子类及父类，同时只能包含公共变量public
        Field[] fields = aClass.getFields();
        log.info("fields = {}", Arrays.toString(fields));
        for (Field field : fields) {

            log.info("class ={},class name ={},class type = {}", field, field.getName(), field.getType());
            System.out.println(field);
            System.out.println(field.getName());
            System.out.println(field.getType());
            // 修饰符
            System.out.println(field.getModifiers());
            System.out.println("-----------");
        }

        System.out.println("===============================");


        // 此方法返回的是当前类的所有属性，不仅仅局限于公共访问修饰符，所有的访问修饰符都可以拿到
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName());

        }

        System.out.println("===============================");
        // 反在在一定程度上破坏了封装性，需要合理使用
        Field address = aClass.getDeclaredField("address");
        // 设置该属性是否能被访问，true表示能被访问，破坏了封装型
        address.setAccessible(true);
        System.out.println(address.getName());
        Object o = aClass.newInstance();
        address.set(o, "北京");
        System.out.println(((Student) o).getAddress());

        System.out.println("=================================");

        // 获取成员方法、包括子类及父类，同时只能包含公共方法
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        System.out.println("=================================");
        // 获取当前类的所有方法，包括私有方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }
        Method add = aClass.getDeclaredMethod("add", Integer.class, Integer.class);
        add.setAccessible(true);
        Object o1 = aClass.newInstance();
        add.invoke(o1, 123, 133);

        System.out.println("===============构造方法==================");
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
        }

        System.out.println("------------------");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.println(constructor);
        }

        System.out.println("-----------------");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class, String.class);
        declaredConstructor.setAccessible(true);
        Student ss = (Student) declaredConstructor.newInstance("22", 22, "ss");
        System.out.println(ss);

    }
}
