package com.datastruct.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Copyright (C), 2017-2022, 赵旭
 * Author: 11931
 * Date: 2022/2/20 19:22
 * FileName: TestSort
 * Description: com.datastruct.test
 * // 测试排序算法是否稳定对应用的影响
 */
public class TestSort {

    public static class Student {
        private String name;
        private int age;
        private int cla;

        public Student(String name, int age, int cla) {
            this.age = age;
            this.name = name;
            this.cla = cla;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", cla=" + cla +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String name = "张三" + i;
            int age = (int) (Math.random() * 100);
            int cla = (int) (Math.random() * 4);
            Student student = new Student(name, age, cla);
            students.add(student);
        }
        students.forEach(System.out::println);


        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.cla - o2.cla == 0 ? (o1.age - o2.age) : (o1.cla - o2.cla);
            }
        });

        System.out.println("---------------------------------------------over--------------------------");
        students.forEach(System.out::println);

    }
}
