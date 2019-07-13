package twopointers;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxContinousSeries_1s {
	static Scanner scan;
	public static void main(String[] args) {
		System.out.println(new MaxContinousSeries_1s().maxone(readInput(), scan.nextInt()));
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
	public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
	
		ArrayList<Integer> lst = new ArrayList<Integer>();
		int wl=0,wr=0;
		int index=0,maxWindow=0;
		int zeroCount=0;
		int s=0,e=0;
		while(wr<a.size())
		{
			if(zeroCount<=b)
			{
				if(a.get(wr)==0)
					zeroCount++;
				wr++;
			}	
			if(zeroCount>b)
			{
				if(a.get(wl)==0)
					zeroCount--;
				wl++;
			}
			
			if(wr-wl > maxWindow )
			{
				maxWindow=wr-wl;
				index=wl;
				s=wl;e=wr;
			}
		}
//		System.out.println("start "+s+"  end "+e);
		/*for(int i=0;i<maxWindow;i++)
		{
			if(a.get(index+i)==0)
				lst.add(index+i); 
				
		}*/
		for(int i=s;i<e;i++)
			lst.add(i);
		return lst;
	}
}
