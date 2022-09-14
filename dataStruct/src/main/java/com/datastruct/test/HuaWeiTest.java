package com.datastruct.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HuaWeiTest {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line == null) {
            return;
        }
        int rand = line.length() / 8;
        int yu = line.length() % 8;
        /*
            total 3 problems:
           1. rand ==0, yu >0
           2. rand >0,yu ==0
           3.rand >0,yu > 0
         */
        if (rand == 0 && yu > 0) {
            String zero = "";
            for (int i = 0; i < 8 - line.length(); i++) {
                zero = zero.concat("0");
            }
            String result = line.concat(zero);
            System.out.println(result);
        } else if (rand > 0 && yu == 0) {
            for (int i = 0; i < rand; i++) {
                String result = line.substring(8 * i, (i + 1) * 8);
                System.out.println(result);
            }
        } else if (rand > 0 && yu > 0) {
            for (int i = 0; i < rand; i++) {
                String result = line.substring(8 * i, (i + 1) * 8);
                System.out.println(result);
            }
            String zero = "";
            for (int i = 0;i<8-yu;i++) {
                zero = zero.concat("0");
            }
            String result = line.substring(rand * 8).concat(zero);
            System.out.println(result);

        }

        HashMap<String,Integer> map = new HashMap<String,Integer>();
        Set<String> strings = map.keySet();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {

        }


    }

    public void test1(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            int k = scanner.nextInt();
            int v = scanner.nextInt();
            map.merge(k, v, Integer::sum);
        }
        map.keySet().stream().sorted().forEach(k -> System.out.println(k + " " + map.get(k)));
    }
}
