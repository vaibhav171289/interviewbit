package twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _3_sum {
	static Scanner scan;
	public static void main(String[] args) {
		System.out.println(new _3_sum().threeSumClosest(readInput(), scan.nextInt()));
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
	public int threeSumClosest(ArrayList<Integer> a, int b) {
	
		Collections.sort(a);
		int n=a.size();
		int min=Integer.MAX_VALUE;
		ArrayList<Integer>res = new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			int l=i+1;
			int r=n-1;
			while(l<r)
			{
				int sum = a.get(i)+a.get(l)+a.get(r);
				if(sum == b)
				{
					return sum;
				}
				else
					if(sum <b)
					{
						l++;
					}else {
							r--;
					}
				if(b<0)
				{
					if( Math.abs(sum-b)<Math.abs(min))
				
					min=sum;
				}else
					if(sum-b<min)
						min=sum;
//			System.out.println("sum "+sum);	
			}
		}
		return min;
	}
}
