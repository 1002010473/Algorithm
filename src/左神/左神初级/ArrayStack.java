package 左神.左神初级;

//固定数组实现栈
public class ArrayStack {
    private String [] items; //数组
    private int count;  //栈中元素个数
    private int n;      //栈的大小

    //初始化大小为n的数组
    public ArrayStack(int n) {
      this.items = new String[n];
      this.n = n;
      this.count = 0;
    }
    //入栈操作
    public boolean push (String item) {
      if (count == n) //如果为n则栈满了，入栈失败
          return false;
      items[count] = item;//将item放到下标为count的位置
      count++;            //并且count加一
      return true;
    }
    //出栈操作
    public String pop () {
      if (count == 0) //如果为零，则栈中无数据
          return null;
      String temp = items[--count]; //返回数组中下标为count—1的值,并且count减一
      return temp;
    }
    public int size(){
        return count;
    }
}
/*
class Test{
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        System.out.println(stack.size());
        stack.push("111");
        stack.push("222");
        System.out.println(stack.size());
        System.out.println(stack.pop());
        stack.push("333");
        System.out.println(stack.push("444"));;
        System.out.println(stack.push("555"));;
    }
}*/
