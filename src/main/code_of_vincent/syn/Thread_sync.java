package syn;

/**
 * @description:两个线程交替打印1A2B3C4D5E6F7G
 * @return:
 * @author: Vincent
 * @time: 2020/11/12 22:52
 */

public class Thread_sync {
    static Thread t1 = null, t2 = null;
    private static Object obj = new Object();
 
    public static void main(String[] args){
        t1 = new Thread(()->{
            for(int i = 1;i<=7;i++){
                synchronized (obj){
                    System.out.print(i);
                    try {
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    obj.notify();//必须要有，不然总会有一个线程最后处于阻塞状态
                }
            }
        });
        t2 = new Thread(()->{
            for(char p = 'A'; p <= 'G'; p++) {
                synchronized (obj){
                    System.out.print(p+"");
                    try {
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    obj.notify();//必须要有，不然总会有一个线程最后处于阻塞状态
                }
            }
        });
        t1.start();
        t2.start();
    }
}