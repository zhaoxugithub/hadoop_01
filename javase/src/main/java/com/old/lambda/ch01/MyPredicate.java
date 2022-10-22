package com.old.lambda.ch01;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}
