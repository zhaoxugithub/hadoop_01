package com.ch01;

public class EASY_addBinary_67 {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        boolean flag = false;
        while (i >= 0 && j >= 0) {
            char ac = a.charAt(i);
            char bc = b.charAt(j);
            if (flag) {
                if (ac == '1' && bc == '1') {
                    sb.append('1');
                    flag = true;
                } else if (ac == '0' && bc == '0') {
                    sb.append('1');
                    flag = false;
                } else {
                    sb.append('0');
                    flag = true;
                }
            } else {
                if (ac == '1' && bc == '1') {
                    sb.append('0');
                    flag = true;
                } else if (ac == '0' && bc == '0') {
                    sb.append('0');
                    flag = false;
                } else {
                    sb.append('1');
                    flag = false;
                }
            }
            i--;
            j--;
        }
        while (i >= 0) {
            if (flag) {
                if (a.charAt(i) == '0') {
                    sb.append('1');
                    flag = false;
                } else {
                    sb.append('0');
                    flag = true;
                }
            } else {
                sb.append(a.charAt(i));
            }
            i--;
        }

        while (j >= 0) {
            if (flag) {
                System.out.println(j);
                if (b.charAt(j) == '0') {
                    sb.append('1');
                    flag = false;
                } else {
                    sb.append('0');
                    flag = true;
                }
            } else {
                sb.append(b.charAt(j));
            }
            j--;
        }

        if (flag) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        String s = new EASY_addBinary_67().addBinary("1", "111");
        System.out.println(s);
    }

}
