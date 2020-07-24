package Algorithm.Window;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/23 9:56
 */
public class lc424_替换后的最长重复字符子串 {
    int[] map = new int[26];
    public int characterReplacement(String s, int k) {
        if (s == null)  return 0;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyCharMax = 0;
        while(right < chars.length){
            int index = chars[right] - 'A';
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]);//每次更新max
            if(right - left + 1 > historyCharMax + k){ // historyCharMax + k 代表了窗口的已知最大长度
                map[chars[left] - 'A']--; //通过增减，map中维护的是正在当前窗口范围内的字符数量
                left++;
            }
            right++;
        }
        return chars.length - left;
    }
}
