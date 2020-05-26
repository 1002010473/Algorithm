package util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HuoChePaiZuo {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    public static int  main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        //int[][] arr = new int[num][2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0; i<num; i++){
            int m = in.nextInt();
            int n = in.nextInt();
            map.put(m,n);
        }
        int[] keya = new int[num];
        int i = 0;
        for (Integer key : map.keySet()) {
            keya[i++] = key;
        }
        Arrays.sort(keya);
        //int h = 0;
        /*for(int k:keya){
            arr[h][0] = k;
            arr[h][1] = map.get(k);
            h++;
        }*/
        int res = 0;
        for(int s = 0; s<num; s++){
            int count = 1;
            //判断前面的下车点是否小于当前的上车点
            for(int j = 0; j < s; j++){
                if(map.get(keya[j])<keya[s]) count++;
            }
            //判断后面的上车点是否小于当前的下车点
            for(int j = s+1; j < num; j++){
                if(keya[j]<map.get(keya[s])) count++;
            }
            res = Math.max(res,count);
        }
        return res;

    }
    /******************************结束写代码******************************/



}
