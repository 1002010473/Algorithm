package Fifty;

import org.junit.Test;

import java.util.Scanner;

/**
 * @description: 第二种方法值得一看，思路很棒
 * @author: 文琛
 * @time: 2020/2/7 19:50
 */
public class FortyThree {
    @Test
    public void easyMethod(){
        int n = 13;
        int number = this.function1(n);
        System.out.println(number);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个正整数：");
        int n = scanner.nextInt();
        int number = function2(n);
        System.out.println(number);
    }

    private static int function2(int n) {
        if(n<=0)
            return 0;

        String strN = String.valueOf(n);
        return numberOf1(strN);
    }

    private static int numberOf1(String strN) {
        if(strN.length() == 1){
            return 1;
        }
        if(new Integer(strN) <= 0){
            return 0;
        }

        int times = 0;

        Integer m = new Integer(strN);
        Integer n = new Integer(strN.substring(1))+1;

        //计算最高位1的个数
        if(new Integer(strN.substring(0, 1)) > 1){
            times += Math.pow(10, strN.length()-1);
        }else{
            times += new Integer(strN.substring(1))+1;
        }

        //计算其他位1的个数
        times += new Integer(strN.substring(0,1)) * (strN.length()-1) * Math.pow(10, strN.length()-2);

        return times + numberOf1(strN.substring(1));
    }

    private int function1(int n) {
        if (n<=0) return 0;
        int number = 0;
        for (int i = 1;i<=n;i++){
            int k =i; //不可对i直接更改，否则影响循环；（或者改动后应再改回原值）
            while (k!=0){
                if (k%10==1) number++;
                k = k/10;
            }
        }
        return number;
    }
}
