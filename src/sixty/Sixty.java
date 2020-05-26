package sixty;

import java.util.Arrays;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/2/15 18:48
 */
public class Sixty {
    public  double[] twoSum(int n) {
        double[][] arr = new double[2][6*n+1];
        for(int i=1;i<=6;i++){
            arr[0][i] = 1;
        }
        int flag=1;
        for(int j=2;j<=n;j++){
            for(int k=j;k<=6*j;k++){
                for(int l=1;l<=6;l++){
                    if((k-l)>=(j-1)){
                        arr[flag][k] += arr[1-flag][k-l];
                    }
                }
            }
            flag=1-flag;
        }
        double[] result = Arrays.copyOfRange(arr[1-flag],n,6*n+1);
        double total = 0;

        for(double x:result){
            total+=x;
        }
        for(int b=0;b<result.length;b++){
            result[b]=result[b]/total;
        }
        return result;
    }

    public static void main(String[] args) {
        Sixty sixty = new Sixty();
        double[] sum = sixty.twoSum(3);
        for(double a : sum){
            System.out.println(a);
        }
    }
}
