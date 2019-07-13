package twopointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _3_pointer_array {
	static Scanner scan;
	public static void main(String[] args) {
		ArrayList<Integer>a = readInput();
				
		System.out.println(new _3_pointer_array().minimize(a, readInput(), readInput()));
	}
	private static ArrayList<Integer> readInput() {

		 scan = new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			lst.add(scan.nextInt());
		}
		System.out.println(lst);
		return lst;
		
	}
	public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
	
		int max =Integer.MIN_VALUE,min= Integer.MAX_VALUE,d1=Integer.MAX_VALUE;
		for(int i=0,j=0,k=0;i<a.size()&&j<b.size()&&k<c.size();)
		{
			min= Integer.min(a.get(i), Integer.min(b.get(j), c.get(k)));
				max  =Integer.max(a.get(i), Integer.max(b.get(j),c.get(k)));
				System.out.println("min "+min+" max "+max);
				if(max-min < d1)
					{
						d1 = max-min;
					}
				if(d1<0) return -d1;
				if(a.get(i) == min)i++;
				else if(b.get(j) == min )j++;
				else k++;
		}
		return d1;
		
	}
}
