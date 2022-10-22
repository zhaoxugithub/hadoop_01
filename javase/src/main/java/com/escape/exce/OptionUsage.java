package com.escape.exce;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * ClassName OptionUsage
 * Description Optional 使用
 * Author 11931
 * Date 2022-10-22:10:58
 * Version 1.0
 **/
@Slf4j
@SuppressWarnings("all")
public class OptionUsage {

    public static class User {
        private String name;

        public String getName() {
            return name;
        }
    }

    // 这种判断空对象是一种常见的方法
    private static void isUserEqualNull() {
        User user = null;
        if (user == null) {
            log.info("user is null");
        } else {
            log.info("user is not null");
        }

        // 上述这段代码和下面这个一个意思
        // Optional.empty() 创建一个空的Optional容器
        Optional<Object> empty = Optional.empty();

        if (empty.isPresent()) {
            log.info("user is null");
        } else {
            log.info("user is not null");
        }
    }

    public static void main(String[] args) {
        isUserEqualNull();

        User user = null;
        // opNullable 方法：如果user 是空的，就会创建一个空的Optional容器对象，
        // 如果不为空就返回这个对象的Optional容器
        Optional<User> optionalUser = Optional.ofNullable(user);

        // 如果optionalUser 容器里面是空的就返回new User()这个对象，如果不为空，就正常返回；换句话说，存在即返回，空则提供默认值
        // 上面的isPresent()方法就可以被orElse()替换
        optionalUser.orElse(new User());
    }


}
