package checkpoint;

import java.util.ArrayList;
import java.util.Scanner;

public class Numrange {
	static Scanner scan;

	public static void main(String[] args) {
		System.out.println(new Numrange().numRange(readInput(), scan.nextInt(), scan.nextInt()));
	}

	private static ArrayList<Integer> readInput() {

		scan = new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			lst.add(scan.nextInt());
		}
		return lst;

	}
	public int numRange(ArrayList<Integer> A, int B, int C) {
		int count = 0;
		int n = A.size();
		for (int i = 0; i < n; i++) {
			int j = i;
			int sum = 0;
			while (j < n) {
				sum = sum + A.get(j);
				if (sum >= B && sum <= C) {
					count++;
				}
				if (sum > C) {
					break;
				}
				j++;
			}
		}
		return count;
}
}