package com.escape.exce;

/**
 * ClassName ExceptionProcess
 * Description 异常处理
 * Author 11931
 * Date 2022-10-22:18:33
 * Version 1.0
 **/
@SuppressWarnings("all")
public class ExceptionProcess {

    private static class User {
    }

    /**
     * Java 异常本质 --抛出异常
     */
    private void throwException() {
        User user = null;

        // 如果user为空就抛出异常
        if (user == null) {
            throw new NullPointerException();
        }
    }

    /**
     * 不能捕获空指针异常
     */
    private void canNotCatchNpeException() {
        try {
            throwException();
        } catch (ClassCastException cce) {
            System.out.println(cce.getMessage());
            System.out.println(cce.getClass().getName());
        }
    }

    /**
     * 能捕获空指针异常
     */
    private void canCatchNpeException() {
        try {
            throwException();
        } catch (ClassCastException cce) {
            System.out.println(cce.getMessage());
            System.out.println(cce.getClass().getName());
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
            System.out.println(npe.getClass().getName());
        }
    }

    public static void main(String[] args) {
        ExceptionProcess process = new ExceptionProcess();
        // process.canNotCatchNpeException();
        process.canCatchNpeException();
    }

}
