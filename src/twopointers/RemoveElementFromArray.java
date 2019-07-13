package twopointers;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveElementFromArray {
	static Scanner scan;
	public static void main(String[] args) {
		System.out.println(new RemoveElementFromArray().removeElement(readInput(), scan.nextInt()));
	}
	private static ArrayList<Integer> readInput() {

		 scan = new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			lst.add(scan.nextInt());
		}
		return lst;
	}
	public int removeElement(ArrayList<Integer> a, int b) {
	int i=0,j=0;
//	System.out.println(a.size());
		while(i<a.size())
		{
			if(a.get(i).intValue()==b)
			{
				
				i++;
				while(i<a.size() && a.get(i).intValue()!=b)
					{
					a.set(j, a.get(i));
					j++;
						i++;
//						System.out.println("i  "+i);
						
					}
//				System.out.println("j "+j);
//				System.out.println(a);
				
			}
			else
				{
					i++;
					j++;
				}
			
		}
//		System.out.println(a);
		return j;
	}
}
