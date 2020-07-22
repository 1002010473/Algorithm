package Algorithm.struct_design;

/**
 * @description:
 *
 * 问题1 为什么要用volatile  ：  A：禁止指令重排 instance = new Singleton() 可以分解为3步操作 ： 1为对象分配内存；
 * 2 初始化； 3 将instance 指向对象 volatile的作用就是防止第三步在前两步之前执行
 *
 * 问题2 为什么需要两次判断： 因为并发访问，getInstance()必需进行同步，首先想到的肯定是在方法上上锁，但是这样的代价太高，
 * 因为只需要在instance初始化之前需要上锁，instance初始化完毕后，不再需要同步，所以可以在方法内部进行同步，但是在上锁之后，
 * 仍有必要进行判断，因为在上锁之后，可能之前进入临界区的线程进行的就是初始化操作
 *
 * 问题3 为什么需要给class对象上锁 因为static修饰了该方法，所以给 this 上锁是不可行的， 同时，此时的instance如果是null
 * 那么上锁的话会报空指针异常
 *
 * @author: 文琛
 * @time: 2020/7/18 15:51
 */
public class Singleton {
    private static volatile Singleton instance;

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (instance){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton ins = Singleton.getInstance();
    }
}