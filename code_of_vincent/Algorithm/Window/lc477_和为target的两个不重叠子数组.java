package Algorithm.window;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/3/18 16:28
 */
public class lc477_和为target的两个不重叠子数组 {
    public static void main(String[] args) {
        int[] arr = {3,1,1,1,5,1,2,1};
        int target =  3;
        System.out.println(minSumOfLengths(arr ,target));
    }
    public static int minSumOfLengths(int[] arr, int target) {
        int left = 0;
        int right = 1;
        int sum = arr[0];
        List<int[]> lists = new ArrayList<>();
        while(left < arr.length){
            if(sum == target){
                int[] list = {left, right};
                lists.add(list);
                sum -= arr[left++];
            }else if(sum < target){
                if(right == arr.length){
                    break;
                }
                sum += arr[right++];
            }else{
                sum -= arr[left++];
            }
        }
        //循环完毕
        if(lists.size() < 2) return -1;
        //无非就是尝试将lists中所有的元素两两组合遍历一遍，如果冲突，continue；否则，尝试更新和的最小值
        //排序帮助剪枝 按照长度进行排序
        lists.sort((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        //Point ： 如何遍历 元素的两两组合
        //两两组合，无先后关系，所以，可以通过如下双重循环实现
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < lists.size(); i++){
            int[] ari = lists.get(i);
            //if((ari[1] - ari[0]) > res / 2) 就这句话导致在相等时仍然进循环，从而超时！！！！
            if((ari[1] - ari[0]) >= res / 2)
                break;
            for(int j = i+1; j < lists.size(); j++){
                int[] arj = lists.get(j);
                if(ari[0] >= arj[1] || ari[1] <= arj[0]){
                    res = Math.min(res, ari[1] - ari[0] + arj[1] - arj[0]);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
