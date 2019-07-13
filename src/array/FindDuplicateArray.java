package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindDuplicateArray {
	private static List<Integer> readInput()
	{
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		List<Integer> lst = new ArrayList<Integer>();
		for(int i=0;i<size;i++)
		{
			lst.add(scan.nextInt());
		}
		return lst;
	}
	public static void main(String[] args) {
		System.out.println(new FindDuplicateArray().repeatedNumber(readInput()));
	}
	public int repeatedNumber(final List<Integer> a) {
		for(int i=0;i<a.size();i++)
		{
			if(a.get(Math.abs(a.get(i))) >= 0 )
			{
				int x = a.get(Math.abs(a.get(i)));
				a.set(Math.abs(a.get(i)), -x);
			}
			else
				return Math.abs(a.get(i));
		}
		return -1;
	}
}