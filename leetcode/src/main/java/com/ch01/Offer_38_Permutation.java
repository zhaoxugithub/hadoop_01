package com.ch01;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
剑指 Offer 38. 字符串的排列
输入一个字符串，打印出该字符串中字符的所有排列。
你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
示例:
输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
 */
public class Offer_38_Permutation {

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[s.length()];
        Set<String> list = new HashSet<>();
        dfs(chars, "", visited, list);
        return list.toArray(new String[0]);
    }

    private void dfs(char[] chars, String s, boolean[] visited, Set<String> list) {
        // 递归临界条件
        if (chars.length == s.length()) {
            list.add(s);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            // 如果节点被访问了，就不可以访问了，主要配合递归函数使用
            if (visited[i]) {
                continue;
            }
            // 当访问的是非临界节点，表示当前节点已经被访问过了
            visited[i] = true;
            // 不断进行递归调用直到临界条件
            dfs(chars, s + chars[i], visited, list);
            // 要把访问条件设置成false,可以方便后续遍历
            visited[i] = false;
        }
    }


    class PNode {
        private int index;
        private char val;

        public PNode(int index, char val) {
            this.index = index;
            this.val = val;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setVal(char val) {
            this.val = val;
        }

        public char getVal() {
            return val;
        }

        public int getIndex() {
            return index;
        }
    }

    public String[] permutation2(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Set<String> set = new HashSet<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            bfs(chars, i, set);
        }
        return set.toArray(new String[0]);
    }

    private void bfs(char[] chars, int i, Set<String> set) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> setChar = new HashSet<>();
        queue.add(i);
        setChar.add(i);
        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            Integer first = queue.poll();
            sb.append(chars[first]);
            for (int j = 0; j < chars.length && j != first; j++) {
                if (!setChar.contains(j)) {
                    queue.add(j);
                    setChar.add(j);
                }
            }
        }
    }
}
