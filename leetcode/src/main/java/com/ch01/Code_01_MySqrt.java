package com.ch01;

public class Code_01_MySqrt {

    public int mySqrt(int x) {
        if (x == 1)
            return 1;
        int min = 0;
        int max = x;
        while (max - min > 1) {
            int m = (max + min) / 2;
            if (x / m < m)
                max = m;
            else
                min = m;
        }
        return min;

    }

    public static void main(String[] args) {
        int i = new Code_01_MySqrt().mySqrt(2);
        double sss = Math.sqrt(0);
        System.out.println(sss);
        System.out.println(i);
    }
}
