package twopointers;

import java.util.ArrayList;
import java.util.Scanner;

public class SortByColor {
	public static void main(String[] args) {
		new SortByColor().sortColors(readInput());
	}
	private static ArrayList<Integer> readInput() {

		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			lst.add(scan.nextInt());
		}
		return lst;
	}
	public void sortColors(ArrayList<Integer> a) {
//		quicksort(a, 0, a.size()-1);
//		System.out.println(a);
		int n = a.size();
		int low=0,high=n-1,mid=0,temp=0;
		while(mid<=high)
		{
			switch(a.get(mid))
			{
			case 0:{
					temp=a.get(low);
					a.set(low, a.get(mid));
					a.set(mid, temp);
					low++;
					mid++;
					break;
			}
			case 1:
			{
				mid++;
				break;
			}
			case 2:
			{
				temp =a.get(mid);
				a.set(mid, a.get(high));
				a.set(high, temp);
				high--;
				break;
			}
			}
		}
//		System.out.println(a);
	}
	private void quicksort(ArrayList<Integer> a,int  i,int j)
	{
		if(i<j)
		{
			int mid = partition(a,i,j);
//			System.out.println("pivot index :"+mid);
			quicksort(a, i	, mid-1);
			quicksort(a, mid+1, j);
		}
	}
	private int partition(ArrayList<Integer> a, int low, int high) {
		int p=a.get(low);
		int i=low;
//		System.out.println("pivot element "+p);
		for(int j=low+1;j<=high;j++)
		{
			if(a.get(j)<=p)
			{
				i++;
				a=swap(a,i,j);
			}
		}
		
		a=swap(a,low,i);
//		System.out.println("partition array "+a);
		return i;
	}
	private ArrayList<Integer> swap(ArrayList< Integer> a,int i,int j)
	{
//		System.out.println("swap index i: "+i+" j: "+j);
		
		int t= a.get(i);
		a.set(i, a.get(j));
		a.set(j, t);
		return a;
	}
}
