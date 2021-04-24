package test;

import java.util.concurrent.locks.LockSupport;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/25 16:04
 */
public class ParkTest {
    public static void t2() throws Exception {
        Thread t = new Thread(new Runnable() {
            private int count = 0;

            @Override
            public void run() {
                long start = System.currentTimeMillis();
                long end = 0;

                while ((end - start) <= 1000) {
                    count++;
                    end = System.currentTimeMillis();
                }

                System.out.println("after 1 second.count=" + count);

                //等待或许许可
                LockSupport.park();
                System.out.println("thread over." + Thread.currentThread().isInterrupted());

            }
        });

        t.start();

        Thread.sleep(2000);

        // 中断线程
        t.interrupt();

        System.out.println("main over");
    }

    public static void main(String[] args) throws Exception {
        t2();
    }
}
