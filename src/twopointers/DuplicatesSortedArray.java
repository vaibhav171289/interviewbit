package twopointers;

import java.util.ArrayList;
import java.util.Scanner;


public class DuplicatesSortedArray {
	public static void main(String[] args) {
		System.out.println(new DuplicatesSortedArray().removeDuplicates(readInput()));
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

	public int removeDuplicates(ArrayList<Integer> a) {

		int i = 0, j = i + 1;
//		System.out.println("a  " + a);
		for (; j < a.size();) {

//			System.out.println("i " + i + "  j  " + j);
			if (a.get(i).intValue() == a.get(j).intValue()) {

				j++;
				
			} else {
//				System.out.println(a.get(i) + " === " + a.get(j));

				if (a.get(i).intValue() >= a.get(i + 1).intValue()) {

					a.set(i + 1, a.get(j));
					j++;
					i++;
				} else {
					i = j;
					j = j + 1;
				}
//				System.out.println(a);
			}
		}
		return i + 1;
	}
}
