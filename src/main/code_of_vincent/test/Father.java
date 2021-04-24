package test;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/22 22:28
 */
public class Father {
    public  static  int a = 10;
    public void fun(){
        System.out.println("f");
    }
}
class Son extends Father{
    public void fun(){
        System.out.println("s");
    }

    public static void main(String[] args) {
        Son s = new Son();
        s.fun();
    }
}
