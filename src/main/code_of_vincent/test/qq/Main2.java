package test.qq;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/6 20:11
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //set，分组，标记对比得到之前增长的范围，迭代
        HashSet[] sets = new HashSet[m];
        for(int i = 0; i < m; i++){
            HashSet<Integer> set = new HashSet<>();
            int num = sc.nextInt();
            for(int j = 0; j < num; j++){
                set.add(sc.nextInt());
            }
            sets[i] = set;
        }
        List<Integer> hasInformed = new ArrayList<>();
        HashSet<Integer> hasSet = new HashSet<>();
        hasSet.add(0);
        hasInformed.add(0);
        int pre = 0, now = 1;
        while((now - pre) > 0){
            for(int i = 0; i < m; i++){
                HashSet<Integer> set = sets[i];
                if(set != null){
                    boolean flag = false;
                    for(int j = pre; j < now; j++){
                        int num = hasInformed.get(j);
                        if(set.contains(num)){
                            flag = true;
                            break;
                        }
                    }
                    if(flag){
                        //遍历set，将其中未出现的全部加入到has里面去，并将数组中的set置为null
                        for (int k : set) {
                            if(!hasSet.contains(k)){
                                hasInformed.add(k);
                                hasSet.add(k);
                            }
                        }
                        sets[i] = null;
                    }
                }
            }
            pre = now;
            now = hasInformed.size();
        }
        System.out.println(hasInformed.size());
    }
}
