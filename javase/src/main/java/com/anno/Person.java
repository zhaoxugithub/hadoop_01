package com.anno;

import java.lang.annotation.Annotation;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/9/18 10:41 上午
 * FileName: Person
 * Description: com.anno
 */
@TestInheritedAnnotation(values = {"value"}, number = 10)
public class Person {
}

class Student extends Person {
    public void test() {
        Class<Student> studentClass = Student.class;
        Annotation[] annotations = studentClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);

        }
    }

    public static void main(String[] args) {
        new Student().test();
    }

 

}
