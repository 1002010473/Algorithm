package ToOffer.twenty;

/**
 * @description:打印1到n位的最大值：通过字符串实现全排列解决大数问题
 * @author: 文琛
 * @time: 2019/12/1 15:51
 */
public class SeventeenPro {
    //打印数
    public void printNumber(StringBuffer sb){
        boolean flag = false;

        for(int i = 0; i < sb.length(); i++){
            if(!flag && sb.charAt(i) != '0'){
                flag = true;
            }
            if(flag){
                System.out.print(sb.charAt(i));
            }
        }
        if(flag)
            System.out.println();
    }

    //打印从1到n位的最大数
    public void Print1ToMaxOfNDigits(int n){
        if(n <= 0)
            return ;

        //初始化数字（用StringBuffer表示）
        StringBuffer sb = new StringBuffer(n);
        for(int i = 0; i < n; i++){
            sb.append('0');
        }

        print1ToMaxOfNDigits_Recursely(sb, n, 0);
    }

    public void print1ToMaxOfNDigits_Recursely(StringBuffer sb, int n, int index){
        //index实现n位数字的递增深入，实现灵活循环。
        if(index == n){
            printNumber(sb);
            return ;
        }

        for(int i = 0; i < 10; i++){
            sb.setCharAt(index, (char)(i+'0'));
            print1ToMaxOfNDigits_Recursely(sb, n, index+1);
        }
    }

    public static void main(String[] args) {
        SeventeenPro test = new SeventeenPro();
        test.Print1ToMaxOfNDigits(3);
    }
}
