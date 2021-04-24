package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description: -- Arrays.sort() 或者 Collections.sort()
 * @author: 文琛
 * @time: 2020/8/27 16:13
 */
public class String字典序实现  {
    public static void main(String[] args) {
        String s1 = "qwer";
        String s2 = "q";
        String s3 = "qwes";

        String[] strs = new String[]{s1, s2, s3};
        Arrays.sort(strs);
        for(String s : strs){
            System.out.println(s);
        }

        List<String> list = new ArrayList<>();
        list.add("c");
        list.add("a");
        list.add("b");
        Collections.sort(list);
        for(String str : list){
            System.out.println(str);
        }
    }
}
