package 左神初级.class_08;


/*
* 汉诺塔问题--左到右，不可以大压小
* 暴力递归
* 怎么试---将问题分解为将n-1移动到help上+++将n移动到target上+++将n-1移动到target上
* base case --- n==1
* 总共需要 2^n -1 步，所以无法进行动态规划的优化
* */
public class Code_02_Hanoi {

	public static void hanoi(int n) {
		if (n > 0) {
			func(n, n, "left", "mid", "right");
		}
	}

	public static void func(int rest, int down, String from, String help, String to) {
		if (rest == 1) {
			System.out.println("move " + down + " from " + from + " to " + to);
		} else {
			func(rest - 1, down - 1, from, to, help);
			func(1, down, from, help, to);
			func(rest - 1, down - 1, help, from, to);
		}
	}

	/*public static void moveLeftToRight(int N) {
		if (N == 1) {
			System.out.println("move 1 from left to right");
		}
		moveLeftToMid(N - 1);
		System.out.println("move " + N + "from left to right");
		moveMidToRight(N - 1);
	}

	public static void moveRightToLeft(int N) {

	}

	public static void moveLeftToMid(int N) {
		if (N == 1) {
			System.out.println("move 1 from left to mid");
		}
		moveLeftToRight(N - 1);
		System.out.println("move " + N + "from left to mid");
		moveRightToMid(N - 1);
	}

	public static void moveMidToLeft(int N) {

	}

	public static void moveRightToMid(int N) {

	}

	public static void moveMidToRight(int N) {
		if (N == 1) {
			System.out.println("move 1 from mid to right");
		}
		moveMidToLeft(N - 1);
		System.out.println("move " + N + "from mid to right");
		moveLeftToRight(N - 1);
	}*/

	public static void main(String[] args) {
		//n--最左边有n层
		int n = 3;
		hanoi(n);
	}

}
