package com.old.base;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Copyright (C), 2017-2022, 赵旭
 * Author: 11931
 * Date: 2022/4/20 0:33
 * FileName: NashornDemo
 * Description: com.java8.base
 */
public class NashornDemo {

    public static void jsTest() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine javaScript = manager.getEngineByName("JavaScript");
        System.out.println(javaScript);
        System.out.println(javaScript.getClass().getName());
        System.out.println("Result   " + javaScript.eval("function f() { return 1;}; f() + 1;"));
    }

    public static void goTest() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine go = manager.getEngineByName("go");
        System.out.println(go);
        System.out.println(go.getClass().getName());

        System.out.println("Result  " + go.eval("func main() {\n" +
                "\n" +
                "\t//一维数组\n" +
                "\n" +
                "\tvar arra [5]int\n" +
                "\tfmt.Println(arra)\n" +
                "\n" +
                "\t//var ar1 =  [5] int {1, 2}\n" +
                "\tvar arr_2 = [5]int{1, 2, 3, 4, 5}\n" +
                "\tfmt.Println(arr_2)\n" +
                "\n" +
                "\tarr_3 := [5]int{1, 2, 3, 4, 5}\n" +
                "\tfmt.Println(arr_3)\n" +
                "\n" +
                "\tarr_4 := [...]int{1, 2, 3, 4, 5, 6}\n" +
                "\tfmt.Println(arr_4)\n" +
                "\n" +
                "\tarr_5 := [5]int{0: 3}\n" +
                "\tfmt.Println(arr_5)\n" +
                "\n" +
                "\t// 二维数组\n" +
                "\tbbb := [3][3]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}\n" +
                "\tfmt.Println(bbb)\n" +
                "}"));
    }

    public static void main(String[] args) throws ScriptException {

        goTest();
    }
}
