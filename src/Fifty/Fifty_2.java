package Fifty;

/**
 * @description: 较之第一问添加了 字符流输入 中读取的条件----即之前的第二遍循环无法使用--需要更新设计结构
 * @author: 文琛
 * @time: 2020/2/12 22:15
 */
public class Fifty_2 {
    private static int[] keys = new int[256];
    private int index=0;
    //字符流模拟（单个字符的输入）
    public void insert(char c){
        if (keys[c]==-1){
            keys[c]=index;
        }else {
            keys[c]=-2;
        }
        index++;
    }
    public char FirstAppearingOnce(){
        int temp = -1;
        int minIndex =300;//给定的最大输入长度
        for (int i=0;i<256;i++){
            if (keys[i]>-1 && minIndex>keys[i]){
                minIndex=keys[i];
                temp= i;
            }
        }
        return (char) temp;
    }

    public static void main(String[] args) {
        for (int i=0;i<256;i++){
            keys[i]=-1;
        }
        Fifty_2 a = new Fifty_2();
        a.insert('g');
        a.insert('o');
        a.insert('o');
        a.insert('g');
        a.insert('l');
        a.insert('e');
        char c = a.FirstAppearingOnce();
        System.out.println(c);

    }
}
