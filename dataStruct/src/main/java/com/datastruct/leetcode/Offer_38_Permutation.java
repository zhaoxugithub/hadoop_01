package com.datastruct.leetcode;

import java.util.HashSet;
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
        //递归临界条件
        if (chars.length == s.length()) {
            list.add(s);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            //如果节点被访问了，就不可以访问了，主要配合递归函数使用
            if (visited[i]) continue;
            //当访问的是非临界节点，表示当前节点已经被访问过了
            visited[i] = true;
            //不断进行递归调用直到临界条件
            dfs(chars, s+chars[i], visited, list);
            //要把访问条件设置成false,可以方便后续遍历
            visited[i] = false;
        }
    }

}
