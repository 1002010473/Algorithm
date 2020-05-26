package Fifty;

import org.junit.Test;

/**
 * @description: 自做 暴力解法--超时
 * @author: 文琛
 * @time: 2020/2/12 20:11
 */
public class FortyNine {
    //暴力解法
    public int nthUglyNumber(int n) {
        if(n<1) throw new IllegalArgumentException("invalid parameters");
        int count=0;
        for(int i =1;;i++){
            int after = divide(i);
            int before = i;
            while(before!=after){
                before=after;
                after=divide(before);
            }
            if(after==1) count++;
            if(count==n) return i;
        }
    }
    public int divide(int i){
        if(i%2==0) {
            i = i/2;
        }
        if(i%3==0){
            i = i/3;
        }
        if(i%5==0){
            i = i/5;
        }
        return i;
    }
    @Test
    public void test(){
        int n=1352;
        int i = nthUglyNumber(n);
        System.out.println(i);
    }
    //高效解法
    public int nthUglyNumber_(int n) {
        int[] arr = new int[n];
        arr[0]=1;
        int nextIndex=1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while(nextIndex<n){
            int nextNum = ((2*arr[index2])>(3*arr[index3]))?(Math.min((3 * arr[index3]), (5 * arr[index5]))):
                    (Math.min(2 * arr[index2], 5 * arr[index5]));
            arr[nextIndex]=nextNum;
            while((2*arr[index2])<=nextNum){
                (index2)++;
            }
            while((3*arr[index3])<=nextNum){
                (index3)++;
            }
            while((5*arr[index5])<=nextNum){
                (index5)++;
            }
            nextIndex++;
        }
        return arr[n-1];
    }
    @Test
    public void test1(){
        int n=1352;
        int i = nthUglyNumber_(n);
        System.out.println(i);
    }

}
