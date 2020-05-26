import java.util.*;
public class Main{
    private static int res = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[(int)Math.pow(2,len)];
        for(int i = 0; i < arr.length ; i ++){
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        for(int i = 0 ; i < m ; i++){
            int j = sc.nextInt();
            rev(j,arr);
            int[] help = arr.clone();
            method(help,0,help.length-1);
            System.out.println(res);
            res = 0;
        }
    }
    public static void rev(int j, int[] arr){
        //按照2的j次方的粒度进行反转
        if(j == 0) return ;
        int size = (int)Math.pow(2,j);
        if(size>arr.length) return ;

        for(int i = 0; i<arr.length; i+=size){
            for(int k = 0; k < (size>>1); k++){
                int tem = arr[i+k];
                arr[i+k] = arr[i+size-1-k];
                arr[i+size-1-k] = tem;
            }
        }
    }
    public static void method(int[] arr,int start,int end){
        //归并排序求逆序对
        if(start>=end) return;
        int mid = start+((end-start)>>1);
        method(arr,start,mid);
        method(arr,mid+1,end);
        merge(arr,start,mid+1,end);
    }
    public static void merge(int[] arr,int s,int m, int e){
        int[] tem = new int[e-s+1];
        int left = s;
        int right = m;
        int index = 0;
        while(left<m && right <= e){
            if(arr[left]<=arr[right]){
                tem[index++] =arr[left++];
            }else{
                res += (m-left);
                tem[index++] = arr[right++];
            }
        }
        while(left<m){
            tem[index++] = arr[left++];
        }
        while(right<=e){
            tem[index++] = arr[right++];
        }
        for(int i = 0 ; i < tem.length;i ++){
            arr[s+i] = tem[i];
        }

    }
}