package com.datastruct.test;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {

    public static boolean isPalindrome(String str) {

        if (str == null || str.length() == 0) {
            return false;
        }
        char[] chars = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char aChar : chars) {
            if (Character.isLetter(aChar)) {
                list.add(Character.toLowerCase(aChar));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != list.get(list.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Madam,i'm Adam"));
    }
}
