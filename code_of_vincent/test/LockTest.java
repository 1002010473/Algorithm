package test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/25 14:32
 */
public class LockTest implements  Runnable{
    ReentrantLock l = new ReentrantLock();
    @Override
    public void run() {
        //等待或许许可
        System.out.println("start lock");
        l.lock();


        /*try {
            l.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        try {
            l.tryLock(1000, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread over." + Thread.currentThread().isInterrupted());
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest lockTest = new LockTest();
        Thread a = new Thread(lockTest);
        Thread b = new Thread(lockTest);
        a.start();
        Thread.sleep(1000);
        b.start();
        Thread.sleep(1000);
        b.interrupt();
    }
}
