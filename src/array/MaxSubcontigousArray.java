package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxSubcontigousArray {
	private static ArrayList<Integer> readInput() {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			lst.add(scan.nextInt());
		}
		return lst;
	}

	public static void main(String[] args) {
		System.out.println(new MaxSubcontigousArray().maxSubArray(readInput()));
	}

	public int maxSubArray(final List<Integer> a) {
		if (a == null || a.size() == 0)
			return 0;
		int maxSum = Integer.MIN_VALUE, curSum = 0;
		int size = a.size();
		for (int i = 0; i < size; i++) {
			curSum = a.get(i) + curSum;
//			System.out.println("maxSum = " + maxSum + " curSum= " + curSum);
//			System.out.println("a.get(" + i + ") = " + a.get(i));
			if ( curSum> maxSum) {
				 maxSum = curSum;
				 System.out.println("i: "+i);
			}
			else if(curSum < 0)
				{
					curSum = 0;
					System.out.println("reset "+i);
				}
		}
		return maxSum;
	}
}