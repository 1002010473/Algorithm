package Algorithm.TopK;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/4 14:33
 */
public class lc658_k个最接近的元素 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //二分查找，找到后双指针
        int left = 0, right = arr.length-1;
        while(left <= right){
            int mid = left + ((right - left) >>> 1);
            if(arr[mid] == x){
                left = mid + 1;//查找右边界
            }else if (arr[mid] > x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        List<Integer> list = new LinkedList<>();
        //right四种情况：
        //右边界  ：： -1  ：： length-1  ：： 小于x的最大值上
        int start = right;
        if(right == -1){
            start = 0;
        }
        //双指针查找，从start开始
        list.add(arr[start]);
        left = start - 1;
        right = start + 1;
        while(list.size() < k){
            int leftDistance = left < 0 ? Integer.MAX_VALUE : x - arr[left];
            int rightDistance = right >= arr.length ? Integer.MAX_VALUE :  arr[right] - x;
            if(leftDistance <= rightDistance){
                list.add(0, arr[left--]);//题目要求必须返回有序的list
            }else{
                list.add(arr[right++]);
            }
        }
        return list;
    }
}
