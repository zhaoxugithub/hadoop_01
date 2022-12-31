package com.datastruct.zuo.tree;

import java.util.*;

/**
 * Copyright (C), 2017-2022, 赵旭
 * Author: 11931
 * Date: 2022/5/30 23:19
 * FileName: Test
 * Description: com.datastruct.zuo.tree
 * <p>
 * 这个类主要是用来测试的
 */
public class Test {

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> characterCharacterMap = new HashMap<>();
        characterCharacterMap.put(')', '(');
        characterCharacterMap.put(']', '[');
        characterCharacterMap.put('}', '{');
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            } else {
                Character pop = null;
                if (!stack.isEmpty()) {
                    pop = stack.pop();
                }
                Character character = characterCharacterMap.get(aChar);
                assert pop != null;
                if (!pop.equals(character)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        /*Node head = new Node(1);
        head.left = new Node(-222222222);
        head.right = new Node(3);
        head.left.left = new Node(Integer.MIN_VALUE);
        head.right.left = new Node(55555555);
        head.right.right = new Node(66);
        head.left.left.right = new Node(777);
        printTree(head);

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.left.right = new Node(7);
        printTree(head);

        head = new Node(1);
        head.left = new Node(1);
        head.right = new Node(1);
        head.left.left = new Node(1);
        head.right.left = new Node(1);
        head.right.right = new Node(1);
        head.left.left.right = new Node(1);
        printTree(head);
        List<Integer> ks = new ArrayList<>();*/
//        boolean valid = isValid("))");
//        System.out.println(valid);
//
//        List<String> list = new ArrayList<>();
        Set<Integer> set = new HashSet<Integer>();
        set.add(2);
        set.add(1);
        set.add(3);
        set.stream().forEach(System.out::println);
        Integer[] t1 = new Integer[3];
        Integer[] integers = set.toArray(new Integer[3]);
        System.out.println(Arrays.toString(integers));
    }
}
