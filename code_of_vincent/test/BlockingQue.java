package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 阻塞队列 juc包下的成员
 * @author: 文琛
 * @time: 2020/7/23 14:39
 */
public class BlockingQue {
    BlockingQueue blockingQueue = new ArrayBlockingQueue(1);
    //AbstractQueuedSynchronizer
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition c = reentrantLock.newCondition();
}
