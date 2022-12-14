package com.old.generics;

import java.util.List;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/9/16 6:16 下午
 * FileName: GenericsTest_02
 * Description: com.base
 */

class A{}
class B extends A {}

public class GenericsTest_02 {

    // 如下两个方法不会报错
    public static void funA(A a) {
        // ...
    }
    public static void funB(B b) {
        funA(b);
        // ...
    }

    // 如下funD方法会报错
//    public static void funC(List<A> listA) {
//        // ...
//    }
//    public static void funD(List<B> listB) {
//        funC(listB); // Unresolved compilation problem: The method doPrint(List<A>) in the type test is not applicable for the arguments (List<B>)
//        // ...
//    }


    public static void funC(List<? extends A> listA) {
        // ...
    }
    public static void funD(List<B> listB) {
        funC(listB); // OK
        // ...
    }




    public static void main(String[] args) {

    }
}
