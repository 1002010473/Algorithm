package Algorithm.TopK;

import java.util.*;

/**
 * @description: 要求时间复杂度低于 O nlogn
 * 可以借助大小为K的堆实现，从而时间复杂度为nlogk，低于nlogn
 * @author: 文琛
 * @time: 2020/7/4 10:11
 */
public class lc347_前K个高频元素 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] ints = topKFrequent(nums, 2);
        for(int i : ints){
            System.out.println(i);
        }
    }
    //借助一遍hash实现频率的统计 n log k
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n, 0)+1);
        }
        //小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(a) - map.get(b));
        for(int n : map.keySet()){
            pq.add(n);
            if(pq.size()>k)
                pq.poll();
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }
        return res;
    }

    //借助一遍hash实现频率的统计 + 数组桶 O n 快一些
    public static int[] topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n, 0)+1);
        }
        //借助桶实现
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null)
                list[i] = new ArrayList();
            list[i].add(key);
        }

        List<Integer> res = new ArrayList<>();
        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
            if(list[i] == null)
                continue;
            res.addAll(list[i]);
        }
        int[] ha = new int[k];
        for(int i = 0; i < k; i++){
            ha[i] = res.get(i);
        }
        return ha;
    }
}
