package Algorithm.binary_search.useless;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/3 16:41
 */
public class lc744_比target大的最小字母 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0,right = letters.length -1;
        //相当于查找右边界
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(letters[mid] == target){
                left = mid + 1;
            }else if(letters[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        //该字符可能处于数组之外，左||右，左：left = 0，正常返回，右：left = length，返回0
        return left < letters.length ? letters[left] : letters[0];
    }
}
