package array;

/**
 * @author vaibhav jain
 * */
/*
 * 

Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,

	  [3,4,-1,1] return 2,

	  [-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.

 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstMissing {
	private static ArrayList<Integer> readInput() {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			lst.add(scan.nextInt());
		}
		return lst;
	}

	public int firstMissingPositive(ArrayList<Integer> a) {
		int j = 0;
		// bring all negative numbers to the start of array
		// by swapping all negative with positive numbers in o(n)
		for (int i = 0; i < a.size(); i++) {
			int val = a.get(i);
			if (val <= 0) {
				int temp = a.get(j);
				a.set(j, val);
				a.set(i, temp);
				j++;
			}
		}
		// start from the first positive index
		for (int i = j; i < a.size(); i++) {
			// find the
			int x = 0;
			if (a.get(i) < 0)
				x -= a.get(i);
			else
				x = a.get(i);
			x += (j - 1);
			if (x >= 0 && x < a.size())
				a.set(x, -a.get(x));
			

		}
		int size = 1;
		for (int k = j; k + j < a.size(); k++) {
			if (a.get(k) > 0)
				break;
			size++;
		}
		return size;
	}

	public static void main(String[] args) {
		System.out.println(new FirstMissing().firstMissingPositive(readInput()));
	}
}