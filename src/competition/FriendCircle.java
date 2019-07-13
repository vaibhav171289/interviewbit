package competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FriendCircle {
	private class Friend {
		private int H = 0;
		private int C = 0;
		private int P = 1;
		private ArrayList<HashMap<Integer, Integer>> g;

		public Friend() {
			H = C = 0;
			P = 1;
			g = new ArrayList<HashMap<Integer, Integer>>();
		}

		public int getP() {
			return P;
		}

		public void setP(int p) {
			P = p;
		}

		public int getC() {
			return C;
		}

		public void setC(int c) {
			C = c;
		}

		public int getH() {
			return H;
		}

		public void setH(int h) {
			H = h;
		}

		public ArrayList<HashMap<Integer, Integer>> getG() {
			return g;
		}

		public void setG(ArrayList<HashMap<Integer, Integer>> g) {
			this.g = g;
		}

		public int multiplyGroups() {
			long t = 1;
			for (HashMap<Integer, Integer> lst : g) {
				t *= lst.size();

			}
			return (int) t % 1000000007;
		}

		public int checkPrimeGroups() {
			int t = 0;
			for (HashMap<Integer, Integer> lst : g) {
				if (isPrime(lst.size()))
					t++;
			}
			return t;
		}

		private boolean isPrime(int n) {
			// Corner cases
			if (n <= 1)
				return false;
			if (n <= 3)
				return true;

			// This is checked so that we can skip
			// middle five numbers in below loop
			if (n % 2 == 0 || n % 3 == 0)
				return false;

			for (int i = 5; i * i <= n; i = i + 6)
				if (n % i == 0 || n % (i + 2) == 0)
					return false;

			return true;
		}
	}

	private static HashMap<Integer, Integer> H = null;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			System.out.println("----------------------");
			int n = sc.nextInt();
			int q = sc.nextInt();
			H = new HashMap<Integer, Integer>();
			FriendCircle fc = new FriendCircle();
			for (int i = 0; i < n; i++)
				H.put(1, sc.nextInt());
			Friend f = null;
			for (int i = 0; i < q; i++) {
				f = fc.divideGroups(sc.nextInt(), sc.nextInt(), f);
			}
		}
	}

	public Friend divideGroups(int x, int y, Friend f) {
		if (f == null) {
			f = new Friend();
			if (H.get(x) > H.get(y))
				f.setH(H.get(x));
			else
				f.setH(H.get(y));
			HashMap<Integer, Integer> l = new HashMap<Integer, Integer>();
			l.put(x, H.get(x));
			l.put(y, H.get(y));
			ArrayList<HashMap<Integer, Integer>> g = f.getG();
			g.add(l);
			f.setG(g);
		} else {
			boolean findX = false, findY = false;
			HashMap<Integer, Integer> g1 = null, g2 = null;
			for (HashMap<Integer, Integer> map : f.getG()) {
				if (!findX && map.containsKey(x)) {
					g1 = map;
					findX = true;
				}
				if (!findY && map.containsKey(y)) {
					g2 = map;
					findY = true;
				}
				if (findX && findY)
					break;
			}
			if (g1 == null && g2 == null) {
				HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
				h.put(x, H.get(x));
				h.put(y, H.get(y));
				ArrayList<HashMap<Integer, Integer>> g = f.getG();
				g.add(h);
				f.setG(g);
				if (H.get(x) > H.get(y))
					if (H.get(x) > f.getH())
						f.setH(H.get(x));
					else {
						if (H.get(y) > f.getH())
							f.setH(H.get(y));
					}
			}
			if (g1 != null && g2 != null) {
				for (Map.Entry<Integer, Integer> i : g2.entrySet()) {
					g1.put(i.getKey(), i.getValue());
					if (H.get(x) > H.get(y))
						if (H.get(x) > i.getValue())
							f.setH(H.get(x));
						else {
							if (H.get(y) > i.getValue())
								f.setH(H.get(y));
						}
				}
				ArrayList<HashMap<Integer, Integer>> m = f.getG();
				m.remove(g2);
				f.setG(m);
			}
			if (g1 == null && g2 != null) {
				g2.put(x, H.get(x));
				if (H.get(x) > f.getH())
					f.setH(H.get(x));

			}
			if (g2 == null && g1 != null) {
				g1.put(y, H.get(y));
				if (H.get(y) > f.getH())
					f.setH(H.get(y));

			}

		}
		f.setC(f.checkPrimeGroups());
		f.setP(f.multiplyGroups());
		return f;
	}

}
