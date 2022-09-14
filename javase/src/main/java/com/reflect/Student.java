package com.reflect;

public class Student extends Person {
    public String className;
    private String address;

    public Student() {
        super();
    }

    private Student(String name, int age, String className) {
        super(name, age);
        this.className = className;
    }

    public Student(String name, int age, String className, String address) {
        super(name, age);
        this.className = className;
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public String getClassName() {
        return className;
    }

    private void add(Integer a, Integer b) {
        System.out.println(a + b);
    }

    @Override
    public String toString() {
        return "Student{" +
                "className='" + className + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
