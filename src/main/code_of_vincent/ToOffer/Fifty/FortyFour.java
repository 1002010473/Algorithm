package ToOffer.Fifty;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/2/7 21:08
 */
public class FortyFour {
    public static void main(String[] args) {
       int index = 1002;
       int n = findNumOfIndex(index);
       System.out.println(n);
    }

    private static int findNumOfIndex(int index) {
        if (index<0) return -1;
        int digits =1;
        while(true){
            int numbers = countOfIntegers(digits);
            if (index<=numbers*digits) return digitAtIndex(index,digits);
            index -= numbers*digits;
            digits++;
        }
    }

    private static int digitAtIndex(int index, int digits) {
        int residual = index % digits;
        int result = index / digits;

        String number =  getBeginNumberOfPlace(digits)+result+"";
        String c = String.valueOf(number.charAt(residual));
        return Integer.valueOf(c);
    }

    private static int countOfIntegers(int digits) {
        if (digits==1) return 10;
        int count = (int) Math.pow(10,digits-1);
        return 9*count;
    }
    private static int getBeginNumberOfPlace(int digits) {
        if (digits == 1) return 0;
        return (int) Math.pow(10, digits - 1);
    }
}
