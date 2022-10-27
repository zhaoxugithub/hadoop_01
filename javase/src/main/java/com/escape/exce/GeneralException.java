package com.escape.exce;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ClassName GeneralException
 * Description TODO
 * Author 11931
 * Date 2022-10-27:1:19
 * Version 1.0
 **/
@SuppressWarnings("all")
@Slf4j
public class GeneralException {

    public static class User {

        private String name;

        public User() {
        }

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // 并发修改异常
    private static void concurrentModificationException(ArrayList<User> users) {
        for (User user : users) {

        }
    }

    public static void main(String[] args) {

        // 1.并发修改异常
        ArrayList<User> users = new ArrayList<User>(
                Arrays.asList(new User("qinyi"), new User("imooc"))
        );

    }
}
