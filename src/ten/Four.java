package ten;

public class Four {
    public static void main(String[] args) {
        //创建二维数组
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean flag = findInt(arr, 16);
        System.out.println(flag);
    }
    /*分析
    * 1：不能从中间开始寻找，而应该从右上角开始
    * 2：将索引设置为右上角 arr[1][4]
    * 3: 比较arr[0][4]和key
    *       相同：找到，flag为true；
    *       不同：arr[0][4]>key：arr[0][4--]
    *            arr[0][4]<key：arr[0++][4]
    * 4:循环到边界停止
    * */
    private static boolean findInt(int[][]arr,int key){
        int row = arr.length;
        int line = arr[0].length;
        int i = 0;
        int j = line-1;
        boolean flag = false;
        while (i < row && j>=0){
            if (arr[i][j]==key){
                flag = true;
                break;
            }else if (arr[i][j]>key){
                j--;
            }else if (arr[i][j]<key){
                i++;
            }

        }

        return flag;
    }

}
