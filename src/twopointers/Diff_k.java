package twopointers;

import java.util.ArrayList;
import java.util.Scanner;

public class Diff_k {
	static Scanner scan;
	public static void main(String[] args) {
		System.out.println(new Diff_k().diffPossible(readInput(), scan.nextInt()));
	}
	private static ArrayList<Integer> readInput() {

		 scan = new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			lst.add(scan.nextInt());
		}
//		System.out.println(lst);
		return lst;
		
	}
	public int diffPossible(ArrayList<Integer> a, int b) {
		
		int n=a.size();
		for(int i=0,j=1; j<n;)
		{
			if(i==j)
			{
				j++;
			}
			else
			{
			int diff=  a.get(j)-a.get(i);
			if(diff==b)
				return 1;
			else if(diff > b)
				i++;
			else
				j++;
				
			}
//			System.out.println("i "+i+"  j  "+j);
		}
		return 0;
	}
}
