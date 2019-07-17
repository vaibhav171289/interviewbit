package array;
/**
 * @author vaibhav jain
 * */
/*
 * 

Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

	[3 4 1 4 1]

Sample Output:

	1

If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1

 * */
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
	/*
	 * negate the number at the index given in the array
	 * ex: 1 3 4 1 2  ==> after negate
	 *     ==> 1 -3 4 1 2
	 *     ==> 1 -3 4 -1 2
	 *     ==> 1 -3 4 -1 -2
	 *     ==> 1 |-3| 4 -1 -2 at -1 value is already negative so we found our duplicate
	 *     time complexity o(n) and space o(1)
	 * */
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