package maths;

import java.util.ArrayList;
import java.util.Scanner;

public class NLengthLessThanK {
	static Scanner scan =null;
	private static ArrayList<Integer> readInput() {
		scan= new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			lst.add(scan.nextInt());
		}
		return lst;
	}
	public static void main(String[] args) {
		System.out.println(new NLengthLessThanK().solve(readInput(), scan.nextInt(), scan.nextInt()));
	}
	 public int solve(ArrayList<Integer> A, int B, int C) {
		 long sum=0;
		 int index =B;
		 int t=C;
		 while(index >=0)
		 {
			 
			 
			 if(C>0)
			 {
				 int count=0;
				 int prod=1;
				 while(B-index<=B)
				 {
					 int rem = t%10;
					 t/=10;

					 for(int j:A)
					 {
						 if(j<rem)
							 count++;
					 }
					 prod*=count;
					 count=0;
					 index--;
				 }
				 sum+=prod;

			 }
		 }
	 return 0;   
	 }
}
