package Algorithm.dac;

/**
 * @description: 采用归并排序的思想，在merge时采取计数措施
 * @author: 文琛
 * @time: 2020/7/14 11:05
 */
public class 剑指51_逆序对 {
    int ans;
    public int reversePairs(int[] arr) {
        if (arr == null || arr.length <= 1)
            return 0;
        //归并排序
        ans = 0;
        depart(arr,0,arr.length-1);
        return ans;
    }
    private void depart(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = start + ((end - start) >> 1);
        depart(arr,start,mid);
        depart(arr,mid+1,end);
        merge(arr,start,mid,end);
    }
    public void merge(int[] arr,int start,int mid,int end){
        int[] tem = new int[end-start+1];
        int i = start;
        int j = mid+1;
        //归并
        int indexCopy = 0;
        while(i <= mid && j <= end){
            if (arr[i] <= arr[j]){
                tem[indexCopy++] = arr[i++];
            }else {
                tem[indexCopy++] = arr[j++];
                ans += (mid-i+1);//只有此处会影响ans
            }
        }
        while(i <= mid){
            tem[indexCopy++] = arr[i++];
        }
        while(j <= end){
            tem[indexCopy++] = arr[j++];
        }
        for(int k = 0; k < tem.length; k++){
            arr[start+k] = tem[k];
        }
    }
}
