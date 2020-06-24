package 左神.左神初级.class_08;
/*
* 题目描述：给定一个array和一个aim，任意选择arr中的元素，判断是否可以累加得到aim
* 其实就是挑选子序列实现sum为aim
* */
public class Code_08_Money_Problem {

	public static boolean money1(int[] arr, int aim) {
		return process1(arr, 0, 0, aim);
	}
	//暴力递归---每个子序列都进行尝试
	//i位置及以后的数组元素是否存在子序列sum==aim
	public static boolean process1(int[] arr, int i, int sum, int aim) {
		//此处sum就是之前累计的元素
		if (sum == aim) {
			return true;
		}
		// sum != aim
		if (i == arr.length) {
			return false;
		}
		//要么加进sum，要么抛弃
		return process1(arr, i + 1, sum, aim) || process1(arr, i + 1, sum + arr[i], aim);
	}

	//	无后效性问题:可变参数固定---结果固定（如何到达当前状态不会影响到后续结果，当前参数固定）--i，sum
	//	====那么可以通过--参数（i，sum）--设计数据结构，实现结果的存储

	//返回的参数是dp[0][0]
	//行数为 0-i 列数为 sum所有的可能性
	//在数组中元素可以为负数的情况下，那么需要sum的范围 为 所有负数之和 和所有正数之和之间
	//此处假设全为正数
	//全为正数，那么也就不需要aim以上的范围了，因为肯定为false
	public static boolean money2(int[] arr, int aim) {
		boolean[][] dp = new boolean[arr.length + 1][aim + 1];
		//boolean数组的默认值为负数
		for (int i = 0; i < dp.length; i++) {
			dp[i][aim] = true;
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = aim - 1; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j];
				if (j + arr[i] <= aim) {
					dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 8 };
		int aim = 12;
		System.out.println(money1(arr, aim));
		System.out.println(money2(arr, aim));
	}

}
