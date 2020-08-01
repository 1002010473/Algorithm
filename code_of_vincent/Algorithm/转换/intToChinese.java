package Algorithm.转换;

/**
 * @description: 给定一个int值m, Math.abs(m) < 100000, 转换为汉字 -- 字节三面
 * @author: 文琛
 * @time: 2020/7/30 15:06
 */
public class intToChinese {
    public static void main(String[] args) {
        String s = method(10000);
        System.out.print(s);
    }
    public static String method(int m){
        if(m == 0) return "零";
        boolean fu = false;
        if(m < 0){
            m = Math.abs(m);
            fu = true;
        }
        int[] num = new int[6];
        int i = 1;//即将要写入的index
        while(m > 0){
            int n = m % 10;
            num[i++] = n;
            m = m / 10;
        }
        char[] cs = new char[10];
        cs[0] = '零'; cs[1] = '一'; cs[2] = '二'; cs[3] = '三'; cs[4] = '四';
        cs[5] = '五'; cs[6] = '六'; cs[7] = '七'; cs[8] = '八'; cs[9] = '九';
        StringBuilder sb = new StringBuilder();
        if(fu)
            sb.append('负');
        for(int j = i - 1; j > 0; j--){
            if(num[j] == 0 ){
                if(sb.length() > 0 && sb.charAt(sb.length() - 1) != cs[0]){
                    sb.append(cs[0]);
                }
                continue;
            }
            sb.append(cs[num[j]]);
            if(j == 5){
                sb.append("万");
            }else if(j == 4){
                sb.append("千");
            }else if(j == 3){
                sb.append("百");
            }else if(j == 2) {
                sb.append("十");
            }
        }
        if(sb.charAt(sb.length() - 1) == '零')
            sb.deleteCharAt(sb.length() -1);
        return sb.toString();
    }
}
