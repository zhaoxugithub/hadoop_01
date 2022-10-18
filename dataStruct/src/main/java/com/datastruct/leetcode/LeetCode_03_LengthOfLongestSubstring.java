package com.datastruct.leetcode;

import java.util.*;

/**
 * ClassName LeetCode_03_LengthOfLongestSubstring
 * Description TODO
 * Author 11931
 * Date 2022-10-17:22:51
 * Version 1.0
 **/
public class LeetCode_03_LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        if (s == null) {
            return 0;
        }
        int i = 0, j = 0, max = 0;
        int len = s.length();
        Set<Character> set = new HashSet<>();
        while (i < len && j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int abcabcbb = lengthOfLongestSubstring("abcabcbb");
        System.out.println("abcabcbb = " + abcabcbb);

    }
}
