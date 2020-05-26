package 左神初级.class_08;
/*
* 暴力递归---求n！
*
* */
public class Code_01_Factorial {
	//假如：不知道怎么算
	public static long getFactorial1(int n) {
		//base case
		if (n == 1)
			return 1L;
		return (long) n * getFactorial1(n - 1);
	}
	//假如--知道怎么算
	public static long getFactorial2(int n) {
		long result = 1L;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(getFactorial1(n));
		System.out.println(getFactorial2(n));
	}

}
