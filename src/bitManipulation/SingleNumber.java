package bitManipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingleNumber {
	static Scanner scan;
public static void main(String[] args) {
	System.out.println(5 | 3);
//	System.out.println(new SingleNumber().singleNumber(readInput()));
}
private static ArrayList<Integer> readInput()
{

	scan = new Scanner(System.in);
	int size = scan.nextInt();
	ArrayList<Integer> lst = new ArrayList<Integer>();
	for(int i=0;i<size;i++)
	{
		lst.add(scan.nextInt());
	}
	return lst;
}
	public int singleNumber(final List<Integer> a) {
	
		int num=0;
		
		for(int i=0;i<a.size();i++)
		{
			num = num^a.get(i);
		}
		return num;
	}
}
