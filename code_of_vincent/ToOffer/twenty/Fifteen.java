package ToOffer.twenty;

/**
 * @description:二进制数中“1”的个数
 * 计算机中使用十六进制代替二进制？
 * 十六进制的表示方法？
 * 有待后续解答
 * @author: 文琛
 * @time: 2019/11/30 16:03
 */
public class Fifteen {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(hammingWeight(n));
        System.out.println(Integer.toBinaryString(n));
    }
    public static int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            if((n & 1) > 0)
                res++;
            n = n>>>1;
        }
        return res;
    }
}
