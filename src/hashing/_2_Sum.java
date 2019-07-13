package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class _2_Sum {
	public static void main(String[] args) {
		ArrayList<Integer> lst = readInput();
		System.out.println(new _2_Sum().twoSum(lst, -5));
	}
	private static ArrayList<Integer> readInput()
	{
		Scanner scan = new Scanner(System.in);

		ArrayList<Integer> lst = new ArrayList<Integer>();
		String s[]= scan.nextLine().split(",");
		int size = s.length;
		for(int i=0;i<size;i++)
		{
			lst.add(Integer.parseInt(s[i].trim()));
		}
		return lst;
	}
	public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
	
		ArrayList<Integer> lst= new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int i=a.size()-1;i>0;i--)
			{
//				if(!map.containsKey(a.get(i)))
					map.put(a.get(i),i);
			}
		int index1 =a.size()+1;
		int index2=a.size()+1;
		for(int i=0;i<a.size();i++)
		{
			int val  = a.get(i);
			int diff = b-val;
			if(map.containsKey(diff))
			{
				System.out.println("index2= "+index2+"\tindex1= "+index1);
				int i2 = map.get(diff);
				System.out.println("i2= "+i2 + "\ti= "+i);
				if(index2>i2 && index1 != i2&& index2>i&& i2!=i)
	            {
	                index2=i2;
	                index1=i;
	            }else if(index2 <= i2 && index1!=i2 && index2>i && i!=i2)
	            {
	                if(index1>i)
	                index1=i;
	            }
	          /*  else if(index2 <= i2 && index1!=i2 && index2<i && i!=i2)
	            {
	            	index2=i;
	                if(index1>i)
	                index1=i;
	            }*/
			}
		}
		if(index1 == a.size()+1 && index2==a.size()+1)
			return lst;
		else
		{
			lst.add(index1+1);
			lst.add(index2+1);
			return lst;
		}
	}
}
