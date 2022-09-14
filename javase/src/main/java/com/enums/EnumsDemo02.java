package com.enums;

/**
 * Copyright (C), 2017-2022, 赵旭
 * Author: 11931
 * Date: 2022/4/3 23:40
 * FileName: EnumsDemo2
 * Description: com.enums
 */
public class EnumsDemo02 {

    public static void main(String[] args) {
        WeekDay sun = WeekDay.SUN;
        if (sun == WeekDay.SAT || sun == WeekDay.SUN) {
            System.out.println("ccc");
        } else {
            System.out.println("vvv");
        }
    }
}
