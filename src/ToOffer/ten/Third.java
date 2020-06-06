package ToOffer.ten;

import org.junit.Test;

public class Third {
    private static int [] duplication = new int[10];
    public static void main(String[] args) {
        int[] arr = {2,3,2,0,2,5,3};
        boolean a = findDuplication(arr);
        System.out.println(a);
        for (int i : duplication) {
            System.out.println(i);
        }
    }
    @Test
    public void test(){
        int [] array = {2,3,5,4,3,2,6,7};
        int a = getDuplication(array);
        System.out.println(a);
    }


    /*分析：
    1 拿到一个数组，进行遍历，拿到每一个元素
    2 将该元素和其索引进行比较
            相同：不做任何处理
            不同：将该元素和该元素作为索引时得到的元素进行比较
                    相同：则判定为重复，输出
                    不同：则交换
    * */
    private static boolean findDuplication(int[] array){
        int length = array.length;
        int count = 0;
        boolean flag = false;
        for (int i = 0; i<length ; i++ ){
            if(array[i] != i){
                if (array[i]==array[array[i]]){
                    flag = true;
                    duplication[count++] =  array[i];
                }else{
                    int temp = array[i];
                    array[i] = array[array[i]];
                    array[temp] = temp;
                }
            }
        }



        return flag;
    }

    private static int getDuplication(int[] arr) {
        int start = 1;
        int end = arr.length - 1;
        while(end >= start) {
            int middle = (end - start) / 2 + start;
            int count = getCount(arr, start, middle);
            if (end == start) {
                if (count > 1)
                    return start;
                else
                    break;
            }
            if (count > middle - start + 1) {
                end = middle;
            }
            else
                start = middle + 1;
        }
        return -1;
    }

    // 计算数组arr元素处在[start, end]范围内元素个数
    private static int getCount(int[] arr, int start, int end) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] <= end) count++;
        }
        return count;
    }
}
