package 左神初级.class_08;
/*
暴力递归

问题描述：母牛每年生一只母牛，新生的母牛三年后也能每年生一只，牛不会死，求n年的数量
* 递归计算问题：先写出几个初始项，然后寻找规律
* 该问题的公式 a(n) = a(n-1) + a(n-3)
1 1
2 2
3 3
4 4
5 6
6 9

* */
public class Code_05_Cow {

	public static int cowNumber1(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		return cowNumber1(n - 1) + cowNumber1(n - 3);
	}

	public static int cowNumber2(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int res = 3;
		int pre = 2;
		int prepre = 1;
		int tmp1 = 0;
		int tmp2 = 0;
		for (int i = 4; i <= n; i++) {
			tmp1 = res;
			tmp2 = pre;
			res = res + prepre;
			pre = tmp1;
			prepre = tmp2;
		}
		return res;
	}

	public static void main(String[] args) {
		int n = 20;
		System.out.println(cowNumber1(n));
		System.out.println(cowNumber2(n));
	}

}
