package Other.知识点;

/**
 * @description:记录常见的异常知识
 * 1
 * RuntimeException是Exception类的子类，Exception类对象是Java程序处理或抛弃的对象，它有各种不同的子类分别对应于不同类型。
 *
 * 其中RuntimeException代表运行时由Java虚拟机生成的例外，
 * 如算术运算异常 ArithmeticException（例如除以 0）、
 *  数组索引越界异常ArrayIndexOutOfBoundsException等；
 * 2
 * 其他则为非运行时异常，
 * 例如输入输出异常IOException等。
 *  IllegalArgumentException不合法的参数异常
 *  阻塞操作超时时抛出异常TimeoutException
 *
 * 注意：Java编译器要求Java程序必须捕获或声明所有的非运行时异常，但对运行时异常可以不做处理。
 *
 *
 * @author: 文琛
 * @time: 2020/2/12 16:05
 */
public class 异常 {
    public static void main(String[] args) throws  Exception{
        //
        method();
        /*try {
            method();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }*/

    }
    //method()上throws抛出了异常，那么必须try--catch || 也在调用它的main方法上throws
    private static void method() throws Exception{
        System.out.println("aaa");
        throw new IllegalArgumentException("输入有误");
    }


}
