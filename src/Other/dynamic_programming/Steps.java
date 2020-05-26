package Other.dynamic_programming;

/**
 * @description:跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级台阶总共有多少种跳法
 * @author: 文琛
 * @time: 2020/2/9 22:46
 */
public class Steps {
    public static void main(String[] args) {
        int n = 3;
        int num = jump(n);
        System.out.println(num);
    }

    private static int jump(int n) {
        if (n<=0) return 0;
        int[] array = new int[n+1];
        array[0]=0;
        array[1]=1;
        array[2]=2;
        for (int i=3;i<=n;i++){
            int k = array[i-1]+array[i-2];
            array[i] = k;
        }
        return array[n];
    }
}
