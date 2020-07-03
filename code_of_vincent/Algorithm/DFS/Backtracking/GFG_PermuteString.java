package Algorithm.DFS.Backtracking;
// Java program to print all permutations
// with respect to cases :按照原有的次序，变换大小写，打印所有的可能性字符串

public class GFG_PermuteString {
	// Function to generate permutations 
	static void permute(String input) {
		int n = input.length();
		// Number of permutations is 2^n 
		int max = 1 << n;
		input = input.toLowerCase();
		// 所有可能性，每个循环打印一个
		//i= 0， 啥也不变， i=1， 只将0位置上的升为upper
		for(int i = 0;i < max; i++) {
			//String不变，只变char[]
			char combination[] = input.toCharArray();
			// If j-th bit is set, we convert it to upper case 
			for(int j = 0; j < n; j++) {
				if(((i >> j) & 1) == 1) 
					combination[j] = (char) (combination[j]-32); 
			}
			// Printing current combination 
			System.out.print(combination); 
			System.out.print(" "); 
		} 
	} 
	
	// Driver Program to test above function 
	public static void main(String[] args) {
		permute("ABC"); 
	} 
} 

