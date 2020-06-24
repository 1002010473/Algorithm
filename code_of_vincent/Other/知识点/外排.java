package Other.知识点;

/**
 * @description: 打印出B数组中有而A数组中没有的元素
 * @author: 文琛
 * @time: 2020/2/17 19:59
 */
public class 外排 {
    public static void main(String[] args) {
        int[] a = {1,3,6};
        int[] b = {2,4,6,8,9};
        print(b,a);
    }

    private static void print(int[] b, int[] a) {
        int indexa = 0;
        int indexb = 0;
        int lenb = b.length;
        int lena = a.length;
        while(indexa<lena && indexb<lenb){
            if(b[indexb]<a[indexa]){
                System.out.println(b[indexb]);
                indexb++;
            }else if(b[indexb]==a[indexa]){
                indexb++;
            }else{
                indexa++;
            }
        }
        if(indexb<lenb){
            for(int j = indexb; j<lenb;j++){
                System.out.println(b[j]);
            }
        }

    }
}
