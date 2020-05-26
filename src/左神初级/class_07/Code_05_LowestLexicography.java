package 左神初级.class_07;

import java.util.Arrays;
import java.util.Comparator;
/*
贪心算法
* 给定字符串数组，将所有字符串组合起来，并得到字典序最小的字符串结果
*
可以通过将字符串数组进行排序来实现，排序的依据就是两个字符串组合的字典序大小
* */
public class Code_05_LowestLexicography {

	/*public static class MyComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			return (a + b).compareTo(b + a);
		}
	}*/

	public static String lowestString(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		//Arrays.sort(strs, new MyComparator());
		Arrays.sort(strs, (a,b)->((a+b).compareTo(b+a)));
		String res = "";
		for (int i = 0; i < strs.length; i++) {
			res += strs[i];
		}
		return res;
	}

	public static void main(String[] args) {
		String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
		System.out.println(lowestString(strs1));

		String[] strs2 = { "ba", "b" };
		System.out.println(lowestString(strs2));

	}

}
