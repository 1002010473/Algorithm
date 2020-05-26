package Fifty;

/**
 * @description: 把数字翻译成字符串
 * @author: 文琛
 * @time: 2020/2/8 22:25
 */
public class FortySix {
    private static int count;
    public static void main(String[] args) {
        int num = 12258;
        int result = findPossibilities(num);
        System.out.println(result);

    }

    private static int findPossibilities(int num) {
        String s = String.valueOf(num);
        count =0;
        find(s,s.length()-1);
        return count;
    }

    private static void find(String s, int end) {
        if (end<=0) {
            count++;
            return;
        }

        int i =end;
        int first = s.charAt(i)-'0';
        int next = s.charAt(i-1)-'0';

        if (first+next*10<26){
            find(s,end-1);
            find(s,end-2);
        }else {
            find(s,end-1);
        }


    }
}
