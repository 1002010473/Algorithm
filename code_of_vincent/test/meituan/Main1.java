package test.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/6 10:07
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < p; i++){
            int k = sc.nextInt();
            map.put(k, 1);
        }
        for(int i = 0; i < q; i++){
            int k = sc.nextInt();
            map.put(k, map.getOrDefault(k, 0) + 2);
        }
        int[] arr = new int[4];
        for(int i : map.keySet()){
            int j = map.get(i);
            arr[j]++;
        }
        for(int i = 1; i < 4; i++){
            System.out.println(arr[i]);
        }
    }
}
