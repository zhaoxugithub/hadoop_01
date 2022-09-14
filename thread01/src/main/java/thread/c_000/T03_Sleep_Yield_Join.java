package thread.c_000;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/8/31 12:13 上午
 * FileName: T03_Sleep_Yield_Join
 * Description: com.java.thread.c_001
 *
 *
 * sleep,wait,join 区别
 */
public class T03_Sleep_Yield_Join {

    public static void main(String[] args) {
////        testSleep();
        testYield();
//        testJoin();
    }
    /**
     * @Description: t.join(), t线程抢占执行
     * @Param:
     * @return:
     * @Author: serendipity
     * @Date: 2021/8/31
     */
    public static void testJoin() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread1 = new Thread(() -> {
            try {
                //先去执行thread方法，底层是调用wait方法，让当前线程先进入到等待队列
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("B" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread1.start();
    }

    /**
     * @Description: 在线程操作中，也可以使用 yield() 方法将一个线程的操作暂时让给其他线程执行
     * @Param:
     * @return:
     * @Author: serendipity
     * @Date: 2021/8/31
     */
    public static void testYield() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                if (i % 2 == 0) Thread.yield();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("B" + i);
                if (i % 2 == 0) Thread.yield();
            }
        }).start();
    }

    /**
     * @Description:
     * @Param:
     * @return:
     * @Author: serendipity
     * @Date: 2021/8/31
     */
    public static void testSleep() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
