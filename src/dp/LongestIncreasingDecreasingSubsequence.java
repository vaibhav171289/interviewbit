package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingDecreasingSubsequence {
	public static void main(String[] args) {
		System.out.println(new LongestIncreasingDecreasingSubsequence().longestSubsequenceLength(readInput()));
	}
	private static ArrayList<Integer> readInput()
	{
		Scanner scan = new Scanner(System.in);

		ArrayList<Integer> lst = new ArrayList<Integer>();
		String s[]= scan.nextLine().split(",");
		int size = s.length;
		for(int i=0;i<size;i++)
		{
			lst.add(Integer.parseInt(s[i].trim()));
		}
		return lst;
	}
	public int longestSubsequenceLength(final List<Integer> A) {
		//complexity is n^2 with dynamic problem
		int size = A.size();
		int[] LIS = new int[size];
		for (int i = 0; i < size; i++) {
			int max = -1;
			for (int j = 0; j < i; j++) {
				// check if previous elements > current element
				if (A.get(i) > A.get(j)) {
				/*	System.out.println("increasing: ");
					System.out.println("value: "+A.get(i) + " <==> "+A.get(j));
					System.out.println("LIS: "+max +" <==> "+LIS[j]);
					*/
					// update the max from the previous entries
					if (max == -1 || max < LIS[j] + 1) {
						max = 1 + LIS[j];
					}
					
				}
			}
			if (max == -1) {
				// means none of the previous element has smaller than arrA[i]
				max = 1;
			}
			LIS[i] = max;
		}
		/*for(int i:LIS)
			System.out.print(i+" ");
		System.out.println();
		*/
		//----------------------------------------------------------
		
		int[] LDS = new int[size];
		for (int i = size-1; i >= 0; i--) {
			int max = -1;
			for (int j = size-1; j > i; j--) {
				// check if previous elements > current element
				if (A.get(i) > A.get(j)) {
					// update the max from the previous entries
					if (max == -1 || max < LDS[j] + 1) {
						max =  LDS[j]+1;
					}
				}
			}
			if (max == -1) {
				// means none of the previous element has smaller than arrA[i]
				max = 1;
			}
			LDS[i] = max;
		}
		/*for(int i:LDS)
			System.out.print(i+" ");
		System.out.println();*/
		
		/* Return the maximum value of lis[i] + lds[i] - 1*/
        int max = LIS[0] + LDS[0] - 1;
        for (int i = 1; i < size; i++)
            if (LIS[i] + LDS[i] - 1 > max)
                max = LIS[i] + LDS[i] - 1;
 
		return max;
	}
}
