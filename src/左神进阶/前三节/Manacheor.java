package 左神进阶.前三节;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/5/20 22:31
 */
public class Manacheor {
    public static void main(String[] args) {
        //String str1 = "abcdcbafabcdck";
        String str2 = "abcba";
        //System.out.println(manacher(str1));
        System.out.println(manacher(str2));
    }

    public static char[] manacherString(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");
        return sb.toString().toCharArray();
    }

    public static int manacher(String str){
        if(str == null || str.length() < 1)
            return 0;
        //添加填充字符
        char[] charArr = manacherString(str);
        //回文半径数组
        int[] radius = new int[charArr.length];
        //回文右边界
        int R = -1;
        //右边界的中心
        int c = -1;
        int max = Integer.MIN_VALUE;
        //遍历节点计算对应的回文半径
        for (int i = 0; i < radius.length; i++) {
            //R>i时，通过Math.min（）实现两种情况的判断
            //两个O（1）情况没判断？判断了，是走Math.min(),但是依然会走下面的循环！
            //左神炫技
            radius[i] = R > i ? Math.min(radius[2*c-i],R-i):1;
            //暴力扩
            while(i+radius[i] < charArr.length && i - radius[i] > -1){
                if(charArr[i-radius[i]] == charArr[i+radius[i]]){
                    //回文半径的值
                    radius[i]++;
                }else{
                    break;
                }
            }
            if(i + radius[i] > R){
                R = i + radius[i];
                c = i;
            }
            max = Math.max(max,radius[i]);
        }
        //至于为什么-1，是因为在计算半径的过程中，存在了将插入符号计算进入半径的问题，画图看一下的话就知道此时半径就
        //相当于原字符串的长度+1，-1即可得子串的长度
        return max-1;
    }

}
