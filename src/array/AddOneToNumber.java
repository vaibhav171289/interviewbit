package array;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AddOneToNumber {
	private static ArrayList<Integer> readInput()
	{
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for(int i=0;i<size;i++)
		{
			lst.add(scan.nextInt());
		}
		return lst;
	}
	public static void main(String[] args) {
		System.out.println(new AddOneToNumber().plusOne(readInput()));
	}
	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		int val=0;
		ArrayList<Integer> lst = new ArrayList<Integer>();
		int count=0;
			
		for(int n:a)
			if(n == 0)
				{
					count++;
					
				}else
					break;
//		System.out.println("count "+count);
		int i=a.size()-1;
		val=a.get(i)+1;
		if(val>9)
		while(val>9 && i>0)
		{
//			System.out.println(i+ " -->val "+val);
			
			lst.add(0);
			a.set(i-1, a.get(i-1)+1);
			val= a.get(i-1);
			i--;
		}
		else
			{
				lst.add(val);
				i--;
			}
		
		for(;i>=count;i--)
		{
			if(a.get(i)==10 || val ==10)
				{
					lst.add(0);
					lst.add(1);
				}else
					lst.add(a.get(i));
		}
		
//		System.out.println(lst);
		if(lst.isEmpty())
			 lst.add(1);
		Collections.reverse(lst);
		return lst;
	}
}
