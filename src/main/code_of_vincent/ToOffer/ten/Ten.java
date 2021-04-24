package ToOffer.ten;

import org.junit.Test;

public class Ten {
    public static void main(String[] args) {
        int n = 2;
        int a = Fibonacci(n);
        System.out.println(a);
    }
    @Test
    public void mainTest(){
        System.out.println(Fibonacci_Easy(100));
    }

    private static int Fibonacci(int n) {
        if (n<=0){
            return 0;
        }else if (n ==1){
           return 1;
        }else{
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }
    private static double Fibonacci_Easy(int n ){
        if (n<=0){
            return 0;
        }else if (n == 1){
            return 1;
        }else{
            double[] array = new double[n+1];
            array[0]=0;
            array[1]=1;
            for (int i = 2; i<= n;i++){
                array[i] = array[i-1]+array[i-2];
            }
            return array[n];
        }
    }
}
