package com.datastruct.newcode.linkedlist;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirstElem(i);
            System.out.println(linkedList);
        }

        linkedList.addElem(2, 666);
        System.out.println(linkedList);

        linkedList.deleteEleByIndex(2);
        System.out.println(linkedList);

        linkedList.deleteEleFirstEle();
        System.out.println(linkedList);

        linkedList.deleteLastEle();
        System.out.println(linkedList);

    }
}
