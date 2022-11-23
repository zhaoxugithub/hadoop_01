package com.datastruct.leetcode;

/**
 * ClassName LeetCode_05_longestPalindrome
 * Description TODO
 * Author 11931
 * Date 2022-10-18:0:09
 * Version 1.0
 **/
public class LeetCode_05_longestPalindrome {

    // 给你一个字符串 s，找到 s 中最长的回文子串。

    /*
        babad

     */
    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        char[] charArray = s.toCharArray();
        int result = 0;
        int[] r = new int[2];
        for (int i = 0; i < len; i++) {
            // 以左边界为开始的元素charArray[i]
            for (int j = i; j < len; j++) {
                // 计算【i~j】元素是否满足最长的回文子串
                if (isF(i, j, charArray)) {
                    System.out.println("i = " + i + "\tj=" + j);
                    if ((j - i + 1) > result) {
                        r[0] = i;
                        r[1] = j;
                        result = j - i + 1;
                    }
                }
            }
        }
        return s.substring(r[0], r[1] + 1);
    }

    public boolean isF(int i, int j, char[] charArray) {
        while (i <= j) {
            if (charArray[i] != charArray[j]) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    // 012345678910
    // aacabdkacaa
    public static void main(String[] args) {
        LeetCode_05_longestPalindrome leetCode_05_longestPalindrome = new LeetCode_05_longestPalindrome();
        String babad = leetCode_05_longestPalindrome.longestPalindrome("aacabdkacaa");
        System.out.println(babad);

        // boolean f = leetCode_05_longestPalindrome.isF(0, 3, "aacabdkacaa".toCharArray());
        // System.out.println(f);
    }
}
