package 左神.左神初级.class_07;

import java.util.Arrays;
import java.util.Comparator;
/*一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。给你每一个项目开始的时间和结束的时间(给你一个数
组，里面是一个个具体的项目)，你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。返回这个最多的宣讲场次。

思路：还是贪心--按照什么贪
1、开始时间越早越好---false 比如：开始时间早，但是持续时间长
2、持续时间越短越好---false 比如：一个短的项目可能占用了两个项目的尾部和头部
3、结束时间越早越好---true

	结束时间判断方案：就按照结束时间，谁最早结束，谁先来---同时将那些冲突的项目抛弃掉
*/

public class Code_06_BestArrange {

	public static class Program {
		public int start;
		public int end;

		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static class ProgramComparator implements Comparator<Program> {

		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;
		}

	}

	public static int bestArrange(Program[] programs, int cur) {
		//Arrays.sort(programs, new ProgramComparator());
		Arrays.sort(programs,(a,b)->a.end-b.end);
		int result = 0;
		//按照end的值从小到大排序，只要end比cur小，无论是否冲突，都已经过去了，抛弃，start比cur小的，冲突，抛弃
		for (int i = 0; i < programs.length; i++) {
			if (cur <= programs[i].start) {
				result++;
				cur = programs[i].end;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Program p1 = new Program(1,3);
		Program p2 = new Program(2,5);
		Program p4 = new Program(2,8);
		Program p3 = new Program(3,6);
		System.out.println(bestArrange(new Program[]{p1,p2,p3,p4},2));

	}

}
