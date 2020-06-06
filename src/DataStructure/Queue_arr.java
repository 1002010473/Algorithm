package DataStructure;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:队列的数组实现--
 *
 * @author: 文琛
 * @time: 2020/2/14 9:42
 */
public class Queue_arr {
    public static void main(String[] args) {
        /*Java自带Queue接口，LinkedList 是其实现类
         * 添加--add 或者 offer 方法
         * 删除--remove 或 poll 方法
         * 查看头元素-- peek 方法
         * 遍历（从头）-- 增强 for 循环
         * */
        Queue<Integer > q = new LinkedList<>();
        q.offer(1);
        q.offer(5);
        q.offer(7);
        for(int e:q){
            System.out.println(e);
        }
    }
    @Test
    public void test(){
        Queue_array q = new Queue_array();
        q.add(1);
        q.add(2);
        q.print();
        int i = q.remove();
        System.out.println(i);
        System.out.println(" ");
        q.print();
        int j = q.remove();
        System.out.println(j);
        q.remove();
    }
    //数组实现队列
    private class Queue_array{
        private int[] arr = new int[5];//定长---长度可扩展则比较繁琐
        private int length ;
        private void add(int i){
            if (length<5){
                arr[length++] = i;
            }else{
                throw new ArrayIndexOutOfBoundsException("队列长度已达上限");
            }

        };
        private int remove(){
            if (length>0){
                int remove = arr[0];
                for (int j=0;j<length-1;j++){
                    arr[j] = arr[j+1];
                }
                length--;
                return remove;
            }else {
                throw new ArrayIndexOutOfBoundsException("队列为空，无法移除");
            }
        }
        private void print(){
            for (int i=0;i<length;i++){
                System.out.println(arr[i]);
            }
        }
    }
}
