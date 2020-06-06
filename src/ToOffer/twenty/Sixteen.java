package ToOffer.twenty;

import org.junit.Test;

/**
 * @description:double类型数值的int次方；
 * @author: 文琛
 * @time: 2019/12/1 14:16
 */
public class Sixteen {
    static boolean invalidInput =false;
    @Test
    public  void testPow(){
        double base = 2.0;
        int exponent = -2147483648;
        double result1 = doublePow_1(base,exponent);
        double result2 = doublePow_2(base,exponent);
        //double result3 = doublePow_3(base,exponent);
        System.out.println("非法输入？"+new Sixteen().invalidInput);
//        System.out.println(result1+" "+result2+" "+result3);
        System.out.println(result1+" "+result2+" ");
    }

    private static double doublePow_3(double base, int exponent) {
        if (exponent==0) return 1.0;
        if (exponent==1) return base;
        double result = doublePow_3(base,exponent>>1);
        result*=result;
        if (exponent%2==1) result*=base;//位与运算符&不能用？原因不详
        return result;
    }

    private static double doublePow_2(double base, int exponent) {
        if (equal(base,0.0) && exponent <=0){
            invalidInput = true;
            return 0.0;
        }
        int absExponent = exponent;
        double result = 0.0;
        if (exponent<0){
            absExponent = -1*exponent;
            result = 1/doublePow_1(base,absExponent);
        }else {
            result = doublePow_1(base,absExponent);
        }
        return result;
    }
    public static boolean equal(double num1, double num2){
        double tmp = num1 - num2;
        if(tmp > -0.0000001 && tmp < 0.0000001)
            return true;
        else
            return false;
    }


    private static double doublePow_1(double base, int exponent) {
        double result = 1.0;
        for (int i = 1 ; i <= exponent ; i++) result *= base;
        return result;
    }
}
