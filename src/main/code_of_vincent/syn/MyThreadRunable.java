package syn;

/**
 * @description:\\
 *
 * 主线程main创建并启动3个子线程，而且这3个子线程都是基于“mt这个Runnable对象”而创建的。
 * 运行结果是这3个子线程一共卖出了10张票。这说明它们是共享了MyThread接口的。
 * @author: 文琛
 * @time: 2020/2/29 12:57
 */
public class MyThreadRunable implements Runnable {

    private int ticket = 10;

    public void run(){
        for(int i = 0; i < 20; i++){
            if(this.ticket > 0){
                System.out.println(Thread.currentThread().getName() + " 卖票：ticket" + this.ticket--);
            }
        }
    }

    public static void main(String[] args) {

        MyThread mt = new MyThread();

        // 启动三个线程，每个线程各卖10张票
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        Thread t3 = new Thread(mt);

        t1.start();
        t2.start();
        t3.start();
    }
}

