package DataStructure;

import java.util.ArrayList;

/**
 * @description: 通过序列 ArrayList（动态数组） 实现队列
 * @author: 文琛
 * @time: 2020/2/14 11:47
 */
public class Queue_arraylist {
    public static void main(String[] args) {
        Queue_arrlist<Integer> q = new Queue_arrlist<>();
        q.add(1);
        q.add(2);
        q.print();
        q.remove();
        q.print();
    }
}
class Queue_arrlist<E> {
    private int length;
    private ArrayList<E> list = new ArrayList<>();
    void add(E element){
        list.add(element);
        length++;
    }
    public E remove(){
        if (!list.isEmpty()){
            length--;
            return list.remove(0);

        }else{
            return null;
        }
    }
    public void print(){
        for (E e : list) {
            System.out.println(e);
        }
    }

}
