package ToOffer.twenty;

/**
 * @description:查找旋转数组的最小数字 - hard
 * @author: 文琛
 * @time: 2019/11/28 10:43
 */
public class Eleven {
    //lc154
    public static int findMin(int[] array){
        //特判
        int len = array.length;
        if (array[0] < array[len - 1])
            return array[0];
        int l = 0;
        int r = len - 1;
        while (l < r){
            int m = l + ((r - l) >> 1);
            if (array[m] > array[r]) {
                l = m + 1;
            }else if (array[m] < array[r]){
                r = m;
            }else{
                r--;
            }
        }
        return array[l];
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,0,1,1};
        int[] arr2 = {3,4,5,6,7,1,2,3};
        int a = findMin(arr);
        int b = findMin(arr2);
        System.out.println(a+"   "+b);
    }
}
