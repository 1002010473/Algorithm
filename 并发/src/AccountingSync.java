import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/2/29 16:26
 */
public class AccountingSync implements Runnable {

    // 共享资源（临界资源）
    static int i = 0;

    public synchronized void increase(){
        i++;
    }

    @Override
    public void run() {
        for(int j = 0; j < 10000; j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        AccountingSync instance = new AccountingSync();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();
        TimeUnit.MICROSECONDS.sleep(1);
        /*t1.join();
        t2.join();*/

        System.out.println(i);   // 输出结果20000
    }
}
