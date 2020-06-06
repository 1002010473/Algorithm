package 左神.左神初级.class_08;

import java.util.HashSet;
/*
* 打印字符串的全排列
* 暴力递归
* */
public class Code_04_Print_All_Permutations {
	//实现字符串的全排列，但是无法避免字符串重复问题
	public static void printAllPermutations1(String str) {
		char[] chs = str.toCharArray();
		process1(chs, 0);
	}
	//递归方法的--语义作用 ： 打印从i开始的字符数组全排列
	public static void process1(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
		}
		for (int j = i; j < chs.length; j++) {
			swap(chs, i, j);
			process1(chs, i + 1);
			swap(chs, i, j);
		}
	}
	//通过set解决重复问题
	private static HashSet<String> set;
	public static void printAllPermutations2(String str) {
		char[] chs = str.toCharArray();
		set = new HashSet<>();
		process2(chs, 0);
	}
	public static void process2(char[] chs, int i) {
		if (i == chs.length) {
			//注意 String.valueOf(chs) 和 chs.toString() 、Arrays.toString(chs) 之间的区别
			//System.out.println(String.valueOf(chs));
			//set.add(Arrays.toString(chs));
			set.add(String.valueOf(chs));
		}

		for (int j = i; j < chs.length; j++) {
			swap(chs, i, j);
			process2(chs, i + 1);
			swap(chs, i, j);

		}
	}
	/*public static void process2(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
		}
		HashSet<Character> set = new HashSet<>();
		for (int j = i; j < chs.length; j++) {
			if (!set.contains(chs[j])) {
				set.add(chs[j]);
				swap(chs, i, j);
				process2(chs, i + 1);
				swap(chs, i, j);
			}
		}
	}*/

	public static void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}

	public static void main(String[] args) {
		String test1 = "abcd";
		printAllPermutations1(test1);
		System.out.println("======");
		printAllPermutations2(test1);
		for(String s:set){
			System.out.println(s);
		}
		System.out.println("======");

		String test2 = "acc";
		printAllPermutations1(test2);
		System.out.println("======");
		printAllPermutations2(test2);
		for(String s:set){
			System.out.println(s);
		}
		System.out.println("======");
	}

}
