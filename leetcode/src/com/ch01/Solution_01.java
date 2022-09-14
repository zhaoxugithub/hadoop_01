package com.ch01;


import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

import java.util.*;


public class Solution_01 {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //两数之和
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }

        }
        return null;
    }

    //整数反转
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (Integer.MAX_VALUE / 10 < x || Integer.MIN_VALUE / 10 > x) return 0;
            int y = x % 10;
            result = result * 10 + y;
            x /= 10;
        }
        return result;
    }

    //回文数
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int pos = x;
        int result = 0;
        while (pos != 0) {
            int res = pos % 10;
            result = result * 10 + res;
            pos /= 10;
        }
        return result == x;
    }

    //罗马数字转整除
    public int romanToInt(String s) {
        /*
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
         */
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();
        int result = 0;
        int i = 0;
        for (i = 0; i < chars.length - 1; ) {

            if (map.get(chars[i]) < map.get(chars[i + 1])) {
                result = result + map.get(chars[i + 1]) - map.get(chars[i]);
                i += 2;
            } else {
                result = result + map.get(chars[i]);
                i++;
            }
        }
        if (i == chars.length - 1) {
            result = result + map.get(chars[i]);
        }
        return result;
    }

    //最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        StringBuilder resultSb = new StringBuilder();

        for (int c = 0; c < strs[0].length(); c++) {
            char tempChar = strs[0].charAt(c);
            boolean flag = true;
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() <= c) {
                    flag = false;
                    break;
                }
                char ch = strs[i].charAt(c);
                System.out.println(ch + ":" + tempChar);
                if (ch != tempChar) {
                    return resultSb.toString();
                }
            }
            if (flag) resultSb.append(tempChar);
        }
        return resultSb.toString();
    }


    //有效的括号
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c == ')' || c == ']' || c == '}')) {
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
                if ((c == ')' && pop != '(') || (c == ']' && pop != '[') || (c == '}' && pop != '{')) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(-1);
        ListNode pre = p;
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;

        }
        pre.next = (l1 == null ? l2 : l1);
        return p.next;
    }

    //删除有序数组中的重复项,使用 O(1) 额外空间  双指针典型问题
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int i = 0;
        int j = i + 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    //移除元素,使用 O(1) 额外空间并 原地 修改输入数组。
    public int removeElement(int[] nums, int val) {

        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (j == nums.length - 1 && nums[j] == val) {
                break;
            }
            if (nums[j] == val && j < nums.length - 1) {
                continue;
            } else {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    //    实现 strStr()
    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.equals("") || needle == null || needle.equals("")) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(i - count)) {
                if ((i - count + 1) == needle.length()) return i - count;
            } else {
                count++;
            }
        }
        return -1;
    }

    //字符串的排列

    public String[] permutation(String s) {
        if (s.length() == 1) {
            return new String[]{s};
        }
        for (int i = 0; i < s.length() - 1; i++) {
            String[] permutation = permutation(s.substring(1));
            for (int j = 0; j < permutation.length; j++) {
                return null;
            }
        }
        return null;
    }

    public int getLength(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i;
            i--;
        }
        return sum;
    }


    //给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
    public int lengthOfLastWord(String s) {
        if ("".equals(s.trim())) {
            return 0;
        }
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }


    public static void main(String[] args) {
//        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
//        int res = new Solution_01().removeElement(arr, 3);
//        System.out.println(res);
//
//        String[] abcs = new Solution_01().permutation("abc");
//        Arrays.stream(abcs).forEach(System.out::println);
    }
}
