package Other.知识点;

/**
 * @description:
 *      GCD
 *      * 求最大公约数 辗转相除法(欧几里德算法) 例如，求（319，377）： ∵ 319÷377=0（余319）
 *      * ∴（319，377）=（377，319）； ∵ 377÷319=1（余58） ∴（377，319）=（319，58）； ∵
 *      * 319÷58=5（余29） ∴ （319，58）=（58，29）； ∵ 58÷29=2（余0） ∴ （58，29）= 29； ∴
 *      * （319，377）=29。 可以写成右边的格式。
 *      * 用辗转相除法求几个数的最大公约数，可以先求出其中任意两个数的最大公约数，再求这个最大公约数与第三个数的最大公约数，依次求下去，直到最后一个数为止。
 *      * 最后所得的那个最大公约数，就是所有这些数的最大公约数。
 * @author: 文琛
 * @time: 2020/2/19 13:46
 */
public class 最大公约数 {
    public static void main(String[] args) {
        int m = 64;
        int n = 72;
        int ans = gcd(m,n);
        System.out.println(ans);

    }

    private static int gcd(int m, int n) {
        int result;
        while(n!=0){
            result = m % n ;
            m = n;
            n = result;
        }
        return m;
    }
}
