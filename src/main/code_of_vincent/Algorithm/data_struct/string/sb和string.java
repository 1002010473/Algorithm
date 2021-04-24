package Algorithm.data_struct.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: lc228
 * @author: 文琛
 * @time: 2020/8/18 15:31
 */
public class sb和string {

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length == 0) return list;
        int i = 0, len = nums.length;//i作为即将开始的index
        while(i < len){
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            int pre = nums[i];
            int j = i + 1;
            while(j < len && nums[j] == pre + 1){//j来到发生断开的index
                pre = nums[j++];
            }
            if(j != i + 1){
                sb.append("->");
                sb.append(nums[j - 1]);
                //注意：如果此处使用
                //sb.append("->" + nums[j - 1]); --
                //此处会生成新的string，大大增大了时间，从 0 ms 到 7 ms
            }
            list.add(sb.toString());
            i = j;
        }
        return list;
    }
}
