package Algorithm.dp;

/**
 * @description: 尝试素质三连（确定临界楼层的最小移动次数）
 * @author: 文琛
 * @time: 2020/6/14 9:52
 */
public class lc887_鸡蛋掉落_HH {
    public static void main(String[] args) {
        int K = 3;//鸡蛋个数
        int N = 14;//N层楼
        System.out.println(method1(K, N));
        System.out.println(method2(K, N));
        System.out.println(method3(K, N));
        System.out.println(method4(K, N));
    }

    //暴力递归尝试 ： k 个鸡蛋， 可以扔鸡蛋的楼层数 ： n，每个都尝试，当n == 1，次数return 1；
    private static int method1(int k, int n) {
        //base case
        //1个鸡蛋：最坏情况-- 扔n次
        if(k == 1)
            return n;
        if(n == 0)
            return 0;
        //遍历递归
        //两层最值:你们每个位置报一下扔完鸡蛋之后最坏情况（两个中较大的那个）下确定F的次数，我挑一个最小的，就是我可以实现的最小次数
        int res = n;
        for(int i = 1; i <= n; i++){
            res = Math.min(res, 1+ Math.max(method1(k-1, i-1), method1(k, n-i)));
        }
        return res;
    }
    //备忘：二维参数 k， n
    static int[][] tab;
    private static int method2(int K, int N) {
        tab = new int[K+1][N+1];
        return fun2(K, N);
    }

    private static int fun2(int K, int N) {
        if(K == 1)
            return N;
        if(N == 0)
            return 0;
        if(tab[K][N] > 0)
            return tab[K][N];
        //遍历递归
        //两层最值
        int res = N;
        for(int i = 1; i <= N; i++){
            res = Math.min(res, 1+ Math.max(fun2(K-1, i-1), fun2(K, N-i)));
        }
        tab[K][N] = res;
        return res;
    }
    //dp: 超时--稍微优化后的逻辑存在错误
    private static int method3(int K, int N) {
        int[][] dp = new int[K+1][N+1];

        for(int i = 0; i <= N; i++){
            dp[1][i] = i;
        }
        for(int i = 1; i <= K; i++){
            dp[i][0] = 0;
        }
        for(int i = 2; i <= K; i++){
            for(int j = 1; j <= N; j++){
                dp[i][j] = j;
                for(int k = 1; k <= j; k++){
                    dp[i][j] = Math.min(dp[i][j], 1+Math.max(dp[i-1][k-1], dp[i][j-k]));
                }
                /*if(j < 8){
                    for(int k = 1; k <= j; k++){
                        dp[i][j] = Math.min(dp[i][j], 1+Math.max(dp[i-1][k-1], dp[i][j-k]));
                    }
                }else{
                    for(int k = j / 2; k <= j; k++){
                        dp[i][j] = Math.min(dp[i][j], 1+Math.max(dp[i-1][k-1], dp[i][j-k]));
                    }
                }*/
            }
        }
        return dp[K][N];
    }
    //dp优化：将遍历寻找最小值的过程替换为二分查找
    private static int method4(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        //边界
        for(int i = 0; i <= N; i++){
            dp[1][i] = i;
        }
        for(int i = 1; i <= K; i++){
            dp[i][0] = 0;
        }
        //遍历
        for(int i = 2; i <= K; i++){
            for(int j = 1; j <= N; j++){
                dp[i][j] = j;
                //二分查找：依据逻辑-最小移动数随N成正比例增大
                //查找1~N范围上二者的最大值
                int l = 1;
                int r = j;
                while(l <= r){
                    int mid = l + (r - l) / 2;
                    int broken = dp[i-1][mid-1];
                    int nobro = dp[i][j-mid];
                    if(broken > nobro){
                        r = mid-1;
                        dp[i][j] = Math.min(dp[i][j], broken+1);
                    }else{
                        l = mid+1;
                        dp[i][j] = Math.min(dp[i][j], nobro+1);
                    }
                }
            }
        }
        return dp[K][N];
    }
}
