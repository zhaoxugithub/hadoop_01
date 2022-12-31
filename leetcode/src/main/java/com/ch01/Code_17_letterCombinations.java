package com.ch01;

import java.util.*;

/**
 * ClassName Code_17_letterCombinations
 * Description TODO
 * Author 11931
 * Date 2022-12-07:21:57
 * Version 1.0
 **/
public class Code_17_letterCombinations {
    public void mockData(Map<String, String> map) {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<String, String> map = new HashMap<String, String>();
        mockData(map);
        Set<String> res = new HashSet<>();
        char[] chars = digits.toCharArray();
        // boolean[][] visited = new boolean[digits.length()][4];
        boolean[] visited = new boolean[digits.length()];
        StringBuilder sb = new StringBuilder();
        process(res, map, chars, sb, visited, 0);
        return new ArrayList<>(res);
    }

    public void process(Set<String> res, Map<String, String> map, char[] group, StringBuilder sb, boolean[] visited, int groupIndex) {
        if (sb.length() == group.length) {
            res.add(sb.toString());
            return;
        }
        // 如果第i组被访问过，进入下一轮
        if (visited[groupIndex]) {
            return;
        }
        visited[groupIndex] = true;
        char[] words = map.get(String.valueOf(group[groupIndex])).toCharArray();
        for (int j = 0; j < words.length; j++) {
            sb.append(words[j]);
            process(res, map, group, sb, visited, groupIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        visited[groupIndex] = false;
    }

    public static void main(String[] args) {
        Code_17_letterCombinations code_17_letterCombinations = new Code_17_letterCombinations();
        List<String> strings = code_17_letterCombinations.letterCombinations("23");
        strings.forEach(System.out::println);
    }
}