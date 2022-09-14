package com.datastruct.newcode.set;

import com.datastruct.newcode.linkedlist.LinkedList;

import java.util.ArrayList;

public class LinkedListSet<E> implements Set<E> {

    private LinkedList linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList();
    }

    public void add(E e) {
        if (!contains(e)) {
            linkedList.addFirstElem(e);
        }

    }

    public boolean contains(E e) {
        return linkedList.isHasEle(e);
    }

    public void remove(E e) {
        linkedList.deleteEle(e);
    }

    public int getSize() {
        return linkedList.getSize();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<String>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            LinkedListSet<String> set1 = new LinkedListSet<String>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<String>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            LinkedListSet<String> set2 = new LinkedListSet<String>();
            for (String word : words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}
