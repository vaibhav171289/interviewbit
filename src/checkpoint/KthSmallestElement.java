package checkpoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallestElement {
	static Scanner scan;

	public static void main(String[] args) {
		System.out.println(new KthSmallestElement().kthsmallest(readInput(), scan.nextInt()));
	}

	private static ArrayList<Integer> readInput() {

		scan = new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			lst.add(scan.nextInt());
		}
		// System.out.println(lst);
		return lst;

	}

	public int kthsmallest(final List<Integer> a, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < a.size(); i++) {
			pq.offer(a.get(i));
		}
		int n = -1;
		while (k > 0) {
			n = pq.poll();
			k--;
		}
		return n;
	}

	// 2 1 4 3 2 k=3
	public int kthsmallest1(final List<Integer> a, int k) {
		int kth = a.get(0);
		for (int i = 1; i < a.size(); i++) {
			if (k-- > 0) {
				if (a.get(i).intValue() > kth) {
					kth = a.get(i).intValue();

				}
				System.out.println("k: " + k);
				System.out.println("kth  " + kth);

			} else {
				if (a.get(i).intValue() < kth) {
					kth = a.get(i).intValue();
					System.out.println("kth  " + kth);
				}
			}
		}

		Collections.sort(a);
		System.out.println(a);
		return kth;
	}
}
