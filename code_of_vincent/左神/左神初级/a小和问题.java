package 左神.左神初级;

/**
 * @description: 归并排序的简单更改应用
 * @author: 文琛
 * @time: 2020/3/17 10:00
 */
public class a小和问题 {
    public static int smallSum(int[] arr){
        if(arr==null||arr.length<2) return 0;
        return mergeSort(arr,0,arr.length-1);
    }

    private static int mergeSort(int[] arr, int start, int end) {
        if(start>=end) return 0;
        int mid = start + ((end-start)>>1);
        return mergeSort(arr,start,mid)+mergeSort(arr,mid+1,end)+merge(arr,start,mid,end);

    }

    private static int merge(int[] arr, int start, int mid, int end) {
        //在合并过程中产生的小和返回给上层
        int sum = 0;
        int[] tem = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=end){
            //更改地方
            if(arr[i]<arr[j]){
                tem[k++] = arr[i];
                sum+=(end-j+1)*arr[i];
                i++;
            }else{
                tem[k++] = arr[j++];
            }
        }
        while(i<=mid){
            tem[k++] = arr[i++];
        }
        while(j<=end){
            tem[k++] = arr[j++];
        }
        for(int s = 0; s <= end-start;s++){
            arr[start+s] = tem[s];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,2};
        System.out.println(smallSum(arr));
    }
}
