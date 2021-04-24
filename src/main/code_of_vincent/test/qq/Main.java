package test.qq;

import java.util.*;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/6 20:58
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        int maxCount = 0;
        for(int i = 0; i < N; i++){
            String s = sc.next();
            int num = map.getOrDefault(s, 0) + 1;
            maxCount = Math.max(maxCount, num);
            map.put(s, num);
        }
        List[] lists = new List[maxCount + 1];
        for(String s : map.keySet()){
            int count = map.get(s);
            if(lists[count] == null){
                List<String> list = new ArrayList<>();
                list.add(s);
                lists[count] = list;
            }
        }
        List<String> smalls = new ArrayList<>();
        List<String> bigs = new ArrayList<>();
        int index = 0;
        while(smalls.size() < K){
            while(lists[index] == null){
                index++;
            }
            List<String> list = lists[index];
            Collections.sort(list);
            for(int i = 0; i < list.size(); i++){
                smalls.add(list.get(i));
            }
            index++;
        }

        index = maxCount;
        while(bigs.size() < K){
            while(lists[index] == null){
                index--;
            }
            List<String> list = lists[index];
            Collections.sort(list);
            for(int i = 0; i < list.size(); i++){
                bigs.add(list.get(i));
            }
            index--;
        }

        for(int i = 0; i < K; i++){
            String s = bigs.get(i);
            int count = map.get(s);
            System.out.println(s + " " + count);
        }
        for(int i = 0; i < K; i++){
            String s = smalls.get(i);
            int count = map.get(s);
            System.out.println(s + " " + count);
        }
    }
}
