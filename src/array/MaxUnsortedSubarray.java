package array;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxUnsortedSubarray {
	public static void main(String[] args) {
		MaxUnsortedSubarray l = new MaxUnsortedSubarray();

		System.out.println(l.subUnsort(readInput()));
	}

	private static ArrayList<Integer> readInput() {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			lst.add(scan.nextInt());
		}

		return lst;
	}

	public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
		int l = -1, r = -1, diff = -1, i = 0;
		for (i = 0; i < A.size() - 1; i++) {
			diff = A.get(i + 1) - A.get(i);
			if (diff < 0)
				break;
		}
		l = i;

		if (l == A.size() - 1) {
			l=-1;
		} else {
			for (i = A.size() - 1; i > 1; i--) {
				diff = A.get(i) - A.get(i - 1);
				if (diff < 0)
					break;
			}
			r = i;
			int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, j = 0;
			for (j = l; j <= r; j++) {
				if (min > A.get(j))
					min = A.get(j);
				if (max < A.get(j))
					max = A.get(j);
			}
			int x = 0;
			for (i = 0; i <= l - 1; i++) {
				if (A.get(i) <= min)
					x++;
				else
					break;

			}
			l = x;
			x = r;
			for (j = r+1; j < A.size(); j++)
			{
				System.out.println("==="+A.get(j));
				if (A.get(j) < max)
				
					x++;
				else
					break;
			}
			r = x;
		}
		ArrayList<Integer> lst = new ArrayList<Integer>();
		if (l == -1 || r == -1)
			lst.add(-1);
		else {
			lst.add(l);
			lst.add(r);
		}
		return lst;
	}
}
