package com.datastruct.oldcode.ch01;



public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<Integer>();
        for (int i = 0; i < 10; i++) {
            arr.addLastElem(i);
        }
        System.out.println(arr);

        arr.addElem(1, 100);
        System.out.println(arr);

        arr.addFirstElem(-1);
        System.out.println(arr);

        arr.deleteEle(2);
        System.out.println(arr);

        arr.deleteEle(4);
        System.out.println(arr);

        arr.deleteFirstEle();
        System.out.println(arr);

        for (int i = 0; i < 4; i++) {
            arr.deleteFirstEle();
            System.out.println(arr);
        }
    }
    public void stat(){

    }
}
