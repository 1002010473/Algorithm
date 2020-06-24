package Other.知识点;

/**
 * @description:
 * 代码块分为：局部代码块，静态代码块，构造代码块，同步代码块
 * @author: 文琛
 * @time: 2020/2/14 20:09
 */
public class 代码块 {
    public static void main(String[] args) {
        int i = 1;
        //静态代码块，控制局部变量的生存时间
        //大括号内创建的变量，只能在大括号，或者大括号内的括号内使用
        {
            System.out.println(i);
            int num=10;
        }
        //System.out.println(num);

        //构造代码块测试
        Student student = new Student();
        Student 李文琛 = new Student("李文琛", 22);
    }
}
class Student{
    String name;
    int age;
    //无参构造--
    public Student(){
    }
    //有参构造
    public Student(String name,int age){
        this.age=age;
        this.name=name;
    }
    {
        System.out.println("构造代码块中的代码在构造函数调用时，会先于构造方法执行，不论是无参构造还是有参构造函数，每" +
                "创建一次对象，执行一次---作用是提取构造函数中的一些共性代码");
    }
    static {
        System.out.println("静态代码块中的代码会在类加载时执行，只执行一次，----用于实现类加载时所需要进行的一些初始化操作");
    }
}
