package 左神初级.class_08;

import java.util.ArrayList;
import java.util.List;
/*
* 打印字符串的所有子序列（不同于子串，无相邻要求，且要有空字符串）
* 暴力递归
* 怎么试--每个位置上都是存在两种选择，留/舍弃
* base case -- 走到了字符串的末尾
*
* */
public class Code_03_Print_All_Subsquences {

	/*public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0);
	}

	public static void process(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		process(chs, i + 1);
		char tmp = chs[i];
		chs[i] = 0;
		process(chs, i + 1);
		chs[i] = tmp;
	}
	
	public static void function(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0, new ArrayList<Character>());
	}
	
	public static void process(char[] chs, int i, List<Character> res) {
		if(i == chs.length) {
			printList(res);
		}
		List<Character> resKeep = copyList(res);
		resKeep.add(chs[i]);
		process(chs, i+1, resKeep);
		List<Character> resNoInclude = copyList(res);
		process(chs, i+1, resNoInclude);
	}
	
	public static void printList(List<Character> res) {
		// ...;
	}
	
	public static List<Character> copyList(List<Character> list){
		return null;
	}
	*/
	//实现
	private static  void method(char[] chars,int index,String s){
		if(index == chars.length)
			System.out.println(s);
		else{
			method(chars,index+1,s);
			method(chars,index+1,s+chars[index]);
		}
	}
	public static void main(String[] args) {
		String test = "abc";
		method(test.toCharArray(),0,"");
		//printAllSubsquence(test);
	}

}
