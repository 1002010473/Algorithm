package forty;

/**
 * @description: 找出数组中出现次数超过一半的数字
 *  思路：
 *  *      数组中一个数字出现的次数比其他所有数字出现的次数的和还要多。
 *  *      在遍历数组的时候保存两个值，一个是数组中的一个数字，一个是该数字出现的次数
 *  *      当我们遍历下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加一
 *  *      如果和我们之间保存的数字不同，则次数减一。当次数为0时，需要保存下一个数字，并将次数设置为1
 * @author: 文琛
 * @time: 2020/2/3 22:08
 */
public class ThirtyNine2 {
    public static void main(String[] args) {
        ThirtyNine2 test = new ThirtyNine2();
        int[] arr = {1,2,1,1,2,2};
        int result = test.overHalfNum(arr);
        System.out.println(result);
    }

    private int overHalfNum(int[] arr) {
        if(arr==null||arr.length==0){
            throw new RuntimeException("输入参数有误");
        }
        int num = arr[0];
        int time = 1;
        for (int i = 1; i<arr.length ; i++ ){
            if (time==0){ //此处是关键--自动获取下一个数字
                num = arr[i];
                time = 1;
            }else{
                if (arr[i]==num){
                    time++;
                }else{
                    time--;
                }
            }
        }
        if (time>0){
            return num;
        }else{
            throw new RuntimeException("没有出现次数超过一半的数字");
        }

    }
}
