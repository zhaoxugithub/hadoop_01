package com.old.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (C), 2017-2022, 赵旭
 * Author: 11931
 * Date: 2022/4/7 14:34
 * FileName: LogDemo03
 * Description: com.log
 */

/*

slf4j 是 log4j 的加强版


 */
public class LogDemo03 {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogDemo03.class);
        int score = 999;
        String name = "张三";
        logger.info("{} 的分数是 {}",name,score);
    }
}
