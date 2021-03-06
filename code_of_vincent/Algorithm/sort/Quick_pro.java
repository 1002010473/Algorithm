package Algorithm.sort;
import static Algorithm.sort.Insertion.exchange;
/**
 * @description: 快速排序的改进版（荷兰国旗）
 * 通过将排序数组划分为三个部分来实现---普通快排划分了两个部分
 * 小于 等于 大于   --- 小于等于 大于等于
 *
 * 经leetcode验证无误  --
 * 简化版 lc75 - 一次partation
 * @author: 文琛
 * @time: 2020/2/18 20:45
 */
public class Quick_pro {
    public static void main(String[] args) {
        int[] array = {5,5,3,8,5,3};
        sort_Quick_pro(array);
        for (int i:array){
            System.out.println(i);
        }
    }

    private static void sort_Quick_pro(int[] array) {
        sort_Quick_pro(array,0,array.length-1);
    }

    private static void sort_Quick_pro(int[] array, int l, int r) {
        if(l >= r)  return;
        //返回的是放置在一个数组中的两个参数--左--右
        int[] mid = sort(array,l,r);
        sort_Quick_pro(array,l,mid[0]);
        sort_Quick_pro(array,mid[1],r);
    }

    private static int[] sort(int[] array, int l, int r) {
        //在循环判断的过程当中，需要划定四个区域 小于 等于 未判断区域 大于 --- 需要三个边界
        int less = l-1;//小于区域 和 等于区域 之间的边界，指向小于区域的最大index
        int more = r+1;//等于区域 和 大于区域 之间的边界，指向大于区域的最小index
        int index = l+1;//循环到的索引 等于区域 和 未判断区域 之间的边界 -- 未判断区域的最小index
        int p = array[l];
        //循环结束的标志：index==more -- 循环到了大于区域
        while(index < more){
            int temp = array[index];
            if(temp < p){
                //小于比较直，那么将等于区域的最左边一个(++less)和当前值交换，从而将当前值放置于小于区域，并且等于区域只需要右移即可(index++)
                exchange(array,++less,index++);
            }else if(temp > p){
                exchange(array,--more,index);//--more上是未判断的值，需要二次判断
            }else{
                index++;//等于比较值，index++即可，啥也不做，将等于区域延长，未判断区域缩短
            }
        }
        return new int[]{less,more};
    }
}
