package ToOffer.forty;

/**
 * @description:二叉搜索树的后序遍历序列------判断数组是否为二叉树的后续遍历
 * 如{5.7.6.9.11.10.8}
 * 576都小于8 左子树
 * 91110都大于8 右子树
 * 再对576进行递归判断即可
 * @author: 文琛
 * @time: 2019/12/13 9:34
 */
public class ThirtyThree {
    public static void main(String[] args) {
        int[] array = {5,7,6,9,11,10,8};
        int[] another = {7,4,6,5};
        //System.out.println(isBack(array));
        System.out.println(isBack(another));

    }

    private static boolean isBack(int[] array) {
        if (array==null||array.length==0) return false;

        int length = array.length;
        return isBack_(array,0,length);
    }

    private static boolean isBack_(int[] array, int start,int length) {
        //拿到数组的末尾值
        int root = array[start+length-1];
        //判断左子树和右子树
        int i = start;
        while (i<start+length-1){
            if (array[i]<root){
                i++;
            }else{
                break;
            }
        }
        int j = i;
        while (j<start+length-1){
            if (array[j]<root){
                return false;
            }else{
                j++;
            }
        }
        //在上面不返回false的情况下，则需要继续递归判断左右子树
        boolean left = true;
        if (i>1+start){
            left = isBack_(array,start,i);
        }
        boolean right = true;
        if (j>i+1){
            right = isBack_(array,i,length-i-1);
        }

        return left&&right;
    }
}
