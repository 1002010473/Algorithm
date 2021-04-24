package ToOffer.twenty;

/**
 * @description:打印从1到最大的n位数；（大数问题 + 字符++技巧）
 * @author: 文琛
 * @time: 2019/12/1 15:22
 */
public class Seventeen {
    StringBuilder sb = new StringBuilder("0");;
    int idx = 0;
    //大数加法。通过sb实现
    public boolean increment(int n){
        boolean carry = false;
        for(int i = 0; i < sb.length(); i++){
            //如果i==0，那么需要加1，如果不为0，且没有进位，那么无需采取任何操作
            if(carry || i == 0){
                if(sb.charAt(i) == '9'){
                    sb.setCharAt(i,'0');
                    carry = true;
                }else{
                    sb.setCharAt(i,(char) (sb.charAt(i) + 1));
                    carry = false;
                }
            }
        }
        if(carry)
            sb.append("1");
        return sb.length() <= n;
    }

    public void save(int ans[]){
        ans[idx] = Integer.parseInt(sb.reverse().toString());
        sb.reverse();
    }

    public int[] printNumbers(int n) {
        int[] ans = new int[(int) Math.pow(10,n) - 1];
        while(increment(n)){
            save(ans);
            idx++;
        }
        return ans;
    }
}
