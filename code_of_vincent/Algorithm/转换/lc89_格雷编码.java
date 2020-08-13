package Algorithm.转换;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 *
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 *
 * 格雷编码序列必须以 0 开头。
 *
 * @author: 文琛
 * @time: 2020/8/13 10:43
 */
public class lc89_格雷编码 {
    //挨个对比尝试，超时 --- 感觉是可以自己想出来的极限了
    public static List<Integer> grayCode(int n) {
        //尝试通过两个list划分区域，实现降低复杂度
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(0);
        for(int i = 1; i < Math.pow(2, n); i++){
            list2.add(i);
        }
        int cur = 0;
        while(list1.size() < Math.pow(2, n)){
            cur = list1.get(list1.size() - 1);
            for(int i = 0; i < list2.size(); i++){
                int comp = list2.get(i);
                //逐位对比
                int res = cur ^ comp;
                int count = 0;
                for(int j = 0; j < n; j++){
                    if((1 & res) == 1)
                        count++;
                    if(count > 1)
                        break;
                    res = res >>> 1;
                }
                if(count == 1){
                    list1.add(comp);
                    list2.remove(i);
                    break;
                }
            }
        }
        return list1;
    }

    public List<Integer> grayCode1(int n) {
        //借鉴题解
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int toAdd = 1;
        for(int i = 0; i < n; i++){
            for(int j = res.size() - 1; j >= 0; j--){
                res.add(res.get(j) + toAdd);
            }
            toAdd = toAdd << 1;
        }
        return res;
    }
}
