package 左神.左神进阶.中三节.dp套路;

/**
 * @description: leetcode 1423 : 题意见相关描述，原以为是动态规划问题，没想到是滑动窗口
 * @author: 文琛
 * @time: 2020/6/4 21:02
 */
public class CardsInLine {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};

    }
    //暴力递归
    public int maxScore(int[] cardPoints, int k) {
        return method(cardPoints, 0, cardPoints.length-1, k);
    }
    public int method(int[] cardPoints, int left, int end, int k){
        if(k == 1)
            return Math.max(cardPoints[left], cardPoints[end]);
        return Math.max(method(cardPoints, left+1, end, k-1) + cardPoints[left], method(cardPoints, left, end-1, k-1) + cardPoints[end]);
    }
    //动态规划（滑动窗口）
    //该方法method()，需要依赖三个变量来确定返回值,dp目前无想法，借鉴leetcode上滑动窗口的解法
    public int maxScore1(int[] cardPoints, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += cardPoints[i];
        }
        int max = sum;
        for(int i = 0; i < k; i++){
            max = Math.max(max, sum - cardPoints[k-1-i] + cardPoints[cardPoints.length-1-i]);
        }
        return max;
    }

}
