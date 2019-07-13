package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MissingRepeatNumber {
	private static ArrayList<Integer> readInput() {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			lst.add(scan.nextInt());
		}
		return lst;
	}
	public static void main(String[] args) {
		System.out.println(new MissingRepeatNumber().repeatedNumber(readInput()));
	}
	public ArrayList<Integer> repeatedNumber(final List<Integer> b) {   
		int A=-1,B=-1;
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.addAll(b);
		ArrayList<Integer> lst = new ArrayList<Integer>();
		
		if(a == null || a.isEmpty())
		{
			lst.add(A);
			lst.add(B);
		}
		else
		{
			for(int i=0;i<a.size();i++)
			{
//				System.out.println(a);
				int val = Math.abs(a.get(i));
//				System.out.println("val = "+val);
				
				if(a.get(val-1) <0)
				{/*
					if(a.get(val-1) = val)
					int t= a.get(val-1);
					a.set(val-1, val);
					a.set(i, t);*/
					A=val;
				}
				else
					
					a.set(val-1, -a.get(val-1));
				
				
			}
//			System.out.println(a);
			for(int i=0;i<a.size();i++)
			{
//				System.out.println(a.get(i));
				if(a.get(i)>0)
				{
					B=(i+1);
					break;
				}
			}
			lst.add(A);
			lst.add(B);
		}
		
		return lst;
	}
}
