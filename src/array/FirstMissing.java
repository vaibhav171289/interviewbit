package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstMissing {
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
		System.out.println(new FirstMissing().firstMissingPositive(readInput()));
	}
	public int firstMissing(ArrayList<Integer> a) {
		int totalSum=0;int nPos=0, lar=1;
		int actSum=0;
		for(int i:a)
		{
			if(i>0)
			{
				actSum+=i;
				nPos++;
				if(lar < i)
					lar=i;
			}
		}
		System.out.println("nPos "+nPos);
		System.out.println("lar "+lar);
		totalSum = (lar*(lar+1))/2;
		System.out.println("total exected sum "+totalSum);
		System.out.println("actual sum from list "+actSum);
		if(totalSum == actSum)
			return lar+1;
		else
			return totalSum-actSum;
		
	}
	public int firstMissingPositive(ArrayList<Integer> a) {
		int j=0;
		for(int i=0;i<a.size();i++)
		{
			int val  = a.get(i);
			if(a.get(i)<=0)
			{
				int temp =a.get(j);
				a.set(j, val);
				a.set(i, temp);
				j++;
			}
		}
		System.out.println(a);
		System.out.println(a.size());
		List<Integer> nlst = a.subList(j, a.size());
		System.out.println(nlst);
		System.out.println(nlst.size());
		for(int i=0;i<nlst.size();i++)
		{
			System.out.println(Math.abs(nlst.get(i)));
		
			if((Math.abs(nlst.get(i))-1)<nlst.size() && nlst.get(Math.abs(nlst.get(i))-1)>0)
			{
				int x = nlst.get(Math.abs(nlst.get(i))-1);
				nlst.set(Math.abs(nlst.get(i))-1, -x);
			}
		}
		System.out.println(nlst);
		for(int k=0;k<nlst.size();k++)
			{
			if(nlst.get(k)>0)
				return k+1;
			}
		return nlst.size()+1;
	}
	
}