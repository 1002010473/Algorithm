package twenty;

/**
 * @description:剪绳子--将长度为n的绳子剪为m段，每段绳子长度乘积的最大值。(m>1)
 * @author: 文琛
 * @time: 2019/11/30 14:42
 */
public class Fourteen {
    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting(8));

        System.out.println(maxProductAfterCutting_0(8));

        System.out.println(maxProductAfterCutting_1(8));
        //考虑在要求必须切分给定段数的基础上进行递归
        System.out.println(progress(6,4));
    }

    private static int progress(int i, int j) {
        if(j==0){
            return i;
        }
        int max = 0;
        for(int l = 1; l < i; l++){
            int tem = l * progress(i-l,j-1);
            max = Math.max(max,tem);
        }
        return max;
    }

    //递归实现
    private static int maxProductAfterCutting_1(int i) {
        if (i<2) return 0;
        if (i==2) return 1;
        if (i==3) return 2;
        return method(i);
    }

    private static int method(int i) {
        if (i==1) return 1;
        if (i==2) return 2;
        if (i==3) return 3;

        int max = 0;
        for (int a=2;a<=i/2;a++){
            int k = method(a)*method(i-a);
            max = Math.max(max,k);
        }
        return max;
    }

    private static int maxProductAfterCutting_0(int i) {
        if (i<0) return -1;
        if (i<2) return 0;
        if (i==2) return 1;
        if (i==3) return 2;

        int[] array = new int[i+1];
        //array[0]=0;
        array[1]=1;
        array[2]=2;
        array[3]=3;
        int max = 0;
        for (int x=4;x<=i;x++){
            for (int y=1;y<=x/2;y++){
                //int tem = array[y]*array[x-y];
                max=Math.max(max,array[y]*array[x-y]);
            }
            array[x] = max;
        }
        return array[i];

    }

    private static int maxProductAfterCutting(int i) {
        /**
         * @description: 贪心算法
         * @param i ：绳子长度
         * @return: int：最大乘积
         * @author: Vincent
         * @time: 2019/11/30 14:46
         */
        if (i<0) return -1;
        if (i<2) return 0;
        if (i==2) return 1;
        if (i==3) return 2;

        int timesOf3 = i/3;
        if (i%3==1) timesOf3--;
        int timesOf2 = (i-3*timesOf3)/2;
        return (int)Math.pow(3,timesOf3) * (int)Math.pow(2,timesOf2);
    }
}
