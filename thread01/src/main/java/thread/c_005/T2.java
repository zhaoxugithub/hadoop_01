package thread.c_005;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/8/31 1:12 下午
 * FileName: T2
 * Description: com.java.thread.c_005
 */
public class T2 {
    private int count = 100;

    public void play() {
        count--;
        System.out.println(Thread.currentThread().getName() + "-->" + count);
    }

    public static void main(String[] args) {
        T2 t = new T2();
        for (int i = 0; i < 100; i++) {
            new Thread(t::play, "Thread" + i).start();
        }
    }
}
