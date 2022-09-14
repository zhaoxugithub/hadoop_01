package com.anno.base.repeatable;

import com.anno.base.target.Hello_01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Copyright (C), 2017-2022, 赵旭
 * Author: 11931
 * Date: 2022/4/11 22:34
 * FileName: Hellos_01
 * Description: com.anno.base.repeatable
 */
@Target(ElementType.TYPE)
public @interface Hellos_01 {
    Hello_01[] value();
}
