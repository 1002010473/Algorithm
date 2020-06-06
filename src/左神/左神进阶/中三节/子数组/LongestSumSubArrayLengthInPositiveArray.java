package 左神.左神进阶.中三节.子数组;

import java.util.HashMap;

/**
 * @description: 给定正数组，求和为k的最长子数组（连续）长度----滑动窗口
 * 此问题对应数组正负不限的leetcode325问题（hash，前缀）
 * @param
 * @return:
 * @author: Vincent
 * @time: 2020/6/5 11:31
 * 此问题按照滑动窗口的标准解法即可实现
 */

public class LongestSumSubArrayLengthInPositiveArray {
	/*该问题采用滑动窗口正确性的论证：
	1 最大长度必然会被发现：假设最大长度为N，left每次移动一位，必然会来到N的左边界，由于右边界必然大于左边界，且当
	left来到左边界时，必然是发生了大于sum的判定，此时right不可能在右边界的外边，此时，left来到左边界，right在右边界
	内，由于数组都为正，所以必然right会向右移，直到达到右边界，所以最大长度必然不可能被错过
	2 任何可能的长度都会被发现
	因为滑动窗口的查找过程相当于right会在每一个位置走过，查找了每个位置作为末尾时的可能性
	*/
	public static int getMaxLength(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k <= 0)
			return 0;
		//L=0代表窗口左边界在0的左边
		//R=0代表窗口右边界在0的右边
		int L = 0;
		int R = 0;
		int sum = arr[0];
		int len = 0;
		while (R < arr.length) {
			if (sum == k) {
				len = Math.max(len, R - L + 1);
				//在等于时，左边界右移和右边界右移的效果相同，因为在左边界右移后，因为数组元素全为正，所以sum必然减小
				//右边界将继续移动，从而到达和右边界右移相同的情况
				sum -= arr[L++];
			} else if (sum < k) {
				R++;
				if (R == arr.length)
					break;
				sum += arr[R];
			} else {
				sum -= arr[L++];
			}
		}
		return len;
	}

	//lc325 数组正负无限制，HashMap的方法，O（n）空间，O（n）时间。
	public int maxSubArrayLen(int[] nums, int k) {
		if (nums.length == 0) return 0;
		int sum = 0, max = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(0, -1); //为了能够使前缀和刚好为k时，计算正确
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				max = Math.max(max, i - map.get(sum - k));
			}
			if (!map.containsKey(sum)) map.put(sum, i);
		}
		return max;
	}

	public static int[] generatePositiveArray(int size) {
		int[] result = new int[size];
		for (int i = 0; i != size; i++) {
			result[i] = (int) (Math.random() * 10) + 1;
		}
		return result;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int len = 20;
		int k = 15;
		int[] arr = generatePositiveArray(len);
		printArray(arr);
		System.out.println(getMaxLength(arr, k));
		System.out.println(getMaxLength(new int[]{3,2},6));

	}

}
