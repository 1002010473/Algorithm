package ToOffer.ten;

public class Five {
    public static void main(String[] args) {
        String s = "awueuf asdf    asdfasdf";
        String s1 =replace(s);
        System.out.println(s1);

    }
    /*分析
    * 1 如书上所述，创建一个O（n）的方法，先遍历数组，查找空格的个数，并将需要的位置添加至末尾，然后只需从后往前添加，这样只会移动
    * 一遍，需要两个指针分别指向从后往前扫描的位置和要复制到的字符数组的起始位置
    *
    * */
    private static String replace(String s){
        StringBuilder builder = new StringBuilder(s);
        int p1 = builder.length()-1;
         for (int i=0;i <= p1;i++){
             if (builder.charAt(i) == ' '){
                 builder.append("  ");

             }
         }
         int p2 = builder.length()-1;
         while (p1>=0){
             if (builder.charAt(p1) == ' '){
                 changeC(builder,p2);
                 p2-=3;


             }else{
                 char c = builder.charAt(p1);
                 builder.setCharAt(p2,c);
                 p2--;
             }
             p1--;
         }
        String s1 = builder.toString();
         return s1;

    }

    private static void changeC(StringBuilder sb ,int p2) {
        sb.setCharAt(p2--,'0');
        sb.setCharAt(p2--,'2');
        sb.setCharAt(p2--,'%');
        /*int a = p2-1;
        sb.replace(a,p2+1,"%20");*/

    }
}
