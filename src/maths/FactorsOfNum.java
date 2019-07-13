package maths;

import java.util.ArrayList;
import java.util.Collections;
//fastest way to find factors of num
public class FactorsOfNum {
	public ArrayList<Integer> allFactors(int a) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		ArrayList<Integer> res1 = new ArrayList<Integer>();
		if (a == 0)
			return res;
		for (int i = 1; i <= Math.sqrt(a); i++) {

			if (a % i == 0) {
				res.add(i);
				if (i != a / i)
					res1.add(a / i);
			}
		}
		Collections.reverse(res1);
		res.addAll(res1);
		return res;
	}
}
