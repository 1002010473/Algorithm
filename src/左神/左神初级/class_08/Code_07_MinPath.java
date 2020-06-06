package 左神.左神初级.class_08;
/*
题目描述：返回矩阵从左上角到右下角的最小路径
无法贪心哦
* */
public class Code_07_MinPath {
	//暴力递归：枚举--将所有的路径都跑一遍，复杂度高
	public static int minPath1(int[][] matrix) {
		return process1(matrix, matrix.length - 1, matrix[0].length - 1);
	}
	//返回 i，j到矩阵左上角的的路径最小值
	public static int process1(int[][] matrix, int i, int j) {
		int res = matrix[i][j];
		if (i == 0 && j == 0) {
			return res;
		}
		if (i == 0 && j != 0) {
			return res + process1(matrix, i, j - 1);
		}
		if (i != 0 && j == 0) {
			return res + process1(matrix, i - 1, j);
		}
		return res + Math.min(process1(matrix, i, j - 1), process1(matrix, i - 1, j));
	}
	//动态规划：将重复计算消除，实现高效的递归
	//什么时候可以实现暴力递归到动态规划的改动？
	//	无后效性问题:可变参数固定---结果固定（如何到达当前状态不会影响到后续结果，当前参数固定）
	//	====那么可以通过--参数--设计数据结构，实现结果的存储

	// 从base case 起步（不依赖其它情况）计算边界请况
	//然后实现普通节点的依赖设置
	public static int minPath2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0)
			return 0;

		int row = m.length;
		int col = m[0].length;
		//二维数组
		int[][] dp = new int[row][col];
		//边界设置
		dp[0][0] = m[0][0];
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + m[i][0];
		}
		for (int j = 1; j < col; j++) {
			dp[0][j] = dp[0][j - 1] + m[0][j];
		}
		//普通节点的依赖情况
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
			}
		}
		return dp[row - 1][col - 1];
	}



	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		System.out.println(minPath1(m));
		System.out.println(minPath2(m));

		m = generateRandomMatrix(6, 7);
		System.out.println(minPath1(m));
		System.out.println(minPath2(m));
	}

	// for test
	public static int[][] generateRandomMatrix(int rowSize, int colSize) {
		if (rowSize < 0 || colSize < 0) {
			return null;
		}
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * 10);
			}
		}
		return result;
	}
}
