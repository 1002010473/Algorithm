package ToOffer.ten;

/**
 * @description: 考虑到题目特点：长度为n，数字范围0~n-1 找重复
            每个位置上都有对应，所以可以通过位置对应来判断
 * @param
 * @return:
 * @author: Vincent
 * @time: 2020/11/13 19:52
 */
public class Third {
    static int ans;
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,5,3};
        boolean flag = findDuplication(arr);
        if(flag){
            System.out.println(ans);
        }else{
            System.out.println("no duplication");
        }
        System.out.println("----------------------");
        int n = getDuplication(arr);
        System.out.println(n);
    }

    private static boolean findDuplication(int[] array){
        //特判
        int len = array.length;
        for(int a : array){
            if(a < 0 || a > len - 1)
                return false;
        }
        //核心逻辑
        for(int i = 0; i < len; i++){
            while(array[i] != i){
                int n = array[i];
                if(array[n] == n){
                    ans = n;
                    return true;
                }else{
                    exchange(array, i, n);
                }
            }
        }
        return false;
    }

    private static void exchange(int[] array, int i, int n) {
        int tmp = array[i];
        array[i] = array[n];
        array[n] = tmp;
    }
    //在不改变数组的前提下，采用二分法实现----注：完全采用二分的逻辑，在肯定存在结果的情况下，最后定位到重复的元素
    //该题等同于lc287
    private static int getDuplication(int[] arr) {
        int l = 1;
        int r = arr.length - 1;
        while(l < r) {
            int mid = ((r - l) >> 1) + l;
            int count = getCount(arr, l, mid);
            if (count > mid - l + 1) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    // 计算数组arr元素处在[start, end]范围内元素个数
    private static int getCount(int[] arr, int start, int end) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] <= end)
                count++;
        }
        return count;
    }
}
