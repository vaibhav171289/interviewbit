package maths;

import java.util.ArrayList;
import java.util.Arrays;

public class AllPrime {
	public static void main(String[] args) {
		AllPrime p = new AllPrime();
		p.sieve(100);
	}

	public ArrayList<Integer> sieve(int a) {
		boolean b[] = new boolean[a + 1];
		Arrays.fill(b, true);
		for (int i = 2; i < b.length; i++) {
			if (b[i] == true) {

				int j = i;
				while ((long) j * i < (long) b.length) {
					b[j * i] = false;

					j++;
				}
				int t = (int) Math.pow(i, 2);
				if (t < b.length)
					b[t] = false;
			}
		}
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 2; i < b.length; i++)
			if (b[i] == true)
				lst.add(i);
		System.out.println(lst);
		return lst;
	}
}
