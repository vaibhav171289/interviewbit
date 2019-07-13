package array;

import java.util.ArrayList;

public class Flip {
	public static void main(String[] args) {
		String s = "00101011100100110111101100011101111011111000011";

		Flip f = new Flip();
		System.out.println("Result == " +f.flip(s));
	}

	private class Result {
		public int i, j, sum;

		public Result(int i, int j, int sum) {
			this.i = i;
			this.j = j;
			this.sum = sum;
		}
	}

	public ArrayList<Integer> flip(String S) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '1')
				a.add(-1);
			else
				a.add(1);
		}
		System.out.println(a);
		Result res, max, max_curr;
		res = new Result(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
		max = new Result(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
		max_curr = new Result(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
		ArrayList<Result> r = new ArrayList<Result>();
		int n = a.size();
		for (int i = 0; i < n; i++) {
			System.out.println("i-->" + i);
			if (max_curr.sum < 0) {
				max_curr.sum = a.get(i);
				max_curr.i = i;
				max_curr.j = i;
			} else {
				max_curr.sum += a.get(i);
				max_curr.j = i;

			}
			System.out.println("max curr sum-->" + max_curr.sum);
			System.out.println("(" + max_curr.i + " , " + max_curr.j + ")");
			System.out.println("before max sum -->" + max.sum);
			System.out.println("(" + max.i + " , " + max.j + ")");
			if (max_curr.sum > max.sum) {
				max.sum = max_curr.sum;
				max.i = max_curr.i;
				max.j = max_curr.j;
			}

			System.out.println("After max sum -->" + max.sum);
			System.out.println("(" + max.i + " , " + max.j + ")");
			System.out.println("\n---------------------------------------\n");
			r.add(new Result(max.i + 1, max.j + 1, max.sum));
		}
		int max_sum = -1, index = -1;
		for (int i = 0; i < r.size(); i++) {
			res = r.get(i);
			System.out.println(res.sum + "===" + res.i + "===" + res.j);
			if (res.sum > max_sum) {
				max_sum = res.sum;
				index = i;
			}
		}
		a.clear();
		if (index > -1) {
			a.add(r.get(index).i);
			a.add(r.get(index).j);
		}
		return a;
	}
}
