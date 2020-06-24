package 左神.左神进阶.中三节;
/**
 * @description: 得到作为公式的字符串所代表的值，公式里面只存在整数、加减乘除、括号
 * ps：公式肯定正确，无需校验+不考虑溢出
 * 实现的数据结构：队列
 * 思路：1、不考虑括号，在进行加减乘除时，需要在遇到队列尾部为乘除时，先进行运算，再将相关数值和符号放入
 * 2、考虑括号：递归实现
 * 设计一个函数： public int[] method（String str， int index）
 * 功能：将目标字符串传入，并传入index，计算index为起始位置，且到下一个对应右括号的运算结果
 * 返回：结果，和计算到的末尾index
 * 函数运行流程：见脑图相关部分：递归调用该函数
 * @param
 * @return:
 * @author: Vincent
 * @time: 2020/5/31 15:38
 */
import java.util.Deque;
import java.util.LinkedList;

public class 公式字符串值的计算 {

	public static int getValue(String str) {
		return value(str.toCharArray(), 0)[0];
	}
	//递归主体：返回值为两个元素的数组，首位为结果，末位为已计算的index
	public static int[] value(char[] str, int i) {
		Deque<String> que = new LinkedList<>();
		//运行过程中，整数数值的累计值
		int pre = 0;
		int[] bra = null;
		while (i < str.length && str[i] != ')') { //碰到）直接返回，因为递归调用的原因，不会出现在一个方法内需要
			//处理其它）的情况
			if (str[i] >= '0' && str[i] <= '9') { //如果i上对应字符为数字，继续累计运算
				pre = pre * 10 + str[i++] - '0';
			} else if (str[i] != '(') { //如果i上对应字符为运算符号，入队，具体实现逻辑在addNum方法中
				addNum(que, pre);
				que.addLast(String.valueOf(str[i++]));
				pre = 0; // 遇到运算符号，入队，pre清零
			} else {//如果i上为（，进行递归调用
				bra = value(str, i + 1);
				pre = bra[0];//pre设置为括号内的结果值
				i = bra[1] + 1;
			}
		}
		addNum(que, pre);
		return new int[] { getNum(que), i };
	}
	//入队
	public static void addNum(Deque<String> que, int num) {
		if (!que.isEmpty()) {
			int cur = 0;
			String top = que.pollLast();
			if (top.equals("+") || top.equals("-")) {
				//如果为加减，将取出来的队尾放回去
				que.addLast(top);
			} else {
				//如果为乘除时，将num替换为运算完的数值
				cur = Integer.parseInt(que.pollLast());
				num = top.equals("*") ? (cur * num) : (cur / num);
			}
		}
		que.addLast(String.valueOf(num));
	}
	//从头到尾计算结果
	public static int getNum(Deque<String> que) {
		int res = 0;
		boolean add = true;
		String cur = null;
		int num = 0;
		while (!que.isEmpty()) {
			cur = que.pollFirst();
			if (cur.equals("+")) {
				add = true;
			} else if (cur.equals("-")) {
				add = false;
			} else {
				num = Integer.parseInt(cur);
				res += add ? num : (-num);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String exp = "2*(70-(65-45))+8*1";
		System.out.println(getValue(exp));

		exp = "4*(6+78)+53-9/2+45*8";
		System.out.println(getValue(exp));

		exp = "10-5*3";
		System.out.println(getValue(exp));

		exp = "-3*4";
		System.out.println(getValue(exp));

		exp = "3+1*4";
		System.out.println(getValue(exp));

	}

}
