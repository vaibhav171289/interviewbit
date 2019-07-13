package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Equal {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			lst.add(scan.nextInt());
		ArrayList<Integer> l = new Equal().equal(lst);
		System.out.println(l);
	}

	public ArrayList<Integer> equal(ArrayList<Integer> A) {
		HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < A.size(); i++) {
			for (int j = i + 1; j < A.size(); j++) {
				Integer a[] = new Integer[2];
				a[0] = i;
				a[1] = j;
				int sum = A.get(i) + A.get(j);
				System.out.println("i: " + i + "\tj: " + j + "\t sum: " + sum);
				if (map.containsKey(sum)) {
					System.out.println("match found");
					Integer[] b = map.get(sum);
//					System.out.println(b[0]+": "+b[1]);
					if (b[0] < a[0] && b[1] != a[1] && b[1] != a[0])
						if (!lst.isEmpty()) {
							int o1 = lst.get(0);
							int o2 = lst.get(1);
							int o3 = lst.get(2);
							int o4 = lst.get(3);
                           System.out.println(o1+":"+b[0]);
                           System.out.println(o2+":"+b[1]);
                           System.out.println(o3+":"+a[0]);
                           System.out.println(o4+":"+a[1]);
							if (!(o1 < b[0] 
									||(o1==b[0] && o2 < b[1])
									||(o1==b[0] && o2==b[1] && o3 < a[0])
									||( o1 == b[0]  &&  o2==b[1] && o3 == a[0]
								    && o4 < a[1]))) {
								System.out.println("check 1");
								lst.clear();
								lst.add(b[0]);
								lst.add(b[1]);
								lst.add(a[0]);
								lst.add(a[1]);
							}
							else{
								System.out.println("check 2");
								lst.clear();
								lst.add(o1);
								lst.add(o2);
								lst.add(o3);
								lst.add(o4);
							}
						} else {
							System.out.println("check 3");
							lst.add(b[0]);
							lst.add(b[1]);
							lst.add(a[0]);
							lst.add(a[1]);
						}
				} else {
					map.put(sum, a);
				}
				Integer t[]=map.get(sum);
				System.out.println(t[0]+", "+t[1]);
				System.out.println(lst);
			}

			System.out.println("----------------------------------");

		}
		return lst;
	}
}
