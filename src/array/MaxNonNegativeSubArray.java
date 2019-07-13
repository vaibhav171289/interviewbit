package array;

import java.util.ArrayList;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer > l = new ArrayList<Integer>();
		l.add(336465782);l.add(-278722862);l.add(-2145174067);l.add(1101513929);
		l.add(1315634022);
		l.add(-1369133069);
		l.add(1059961393);l.add(628175011);l.add(-1131176229);l.add(-859484421);
		System.out.println(maxset(l));
	}
	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
		long maxSum=0;
		int ps=0,cs=0;
		long sum=0;
		ArrayList<Integer> res = new ArrayList<Integer>();
		ArrayList<Integer> prev = new ArrayList<Integer>();
		long prevSum=0;
		for(int i=0;i<a.size();i++)
		{
			res = new ArrayList<Integer>();
			
			while(i < a.size() && a.get(i)>=0)
			{
				print("value "+a.get(i));
				if(maxSum ==0)
					cs=i;
				print("current index "+cs +" i "+i);
				print("prev index "+ps);
				sum+=a.get(i);
				maxSum=Math.max(maxSum, sum);
				print("sum "+sum);
				print(maxSum +" --> "+prevSum);
				if(a.get(i)>=0)
				{
					
					res.add(a.get(i));
				}
				i++;
			}
			if(i <a.size())
			print("value "+a.get(i));
			print("maxSum "+maxSum +" Sum "+sum);
			if(maxSum >= sum   )
			{
				if(maxSum == prevSum)
				{
					print("sum equal");
					if(prev.size() == res.size())
					{
						if(cs > ps)
						{prev=prev;}
							
					}
					else
						if(res.size() > prev.size())
						{
							prev=res;

							prevSum=maxSum;
							ps=cs;
						}
				}
				else
					if(prevSum == 0 || prevSum < maxSum)
					{
						print(" before prevSUm "+prevSum );
						prev=res;
						ps=cs;
						prevSum=maxSum;
						print("after prevSum "+prevSum);
					}
				res = new ArrayList<Integer>();
				sum=0;
				maxSum=0;
				
			}
		/*	if(prev.size() ==0)
			prev=null;*/
			
		}
		
		return prev;
	}
	private static void print(String s)
	{
		System.out.println(s);
	}
	
	//good nice and clean easy approach
	public ArrayList<Integer> maxset1(ArrayList<Integer> a) {
	    long maxSum = 0;
	    long newSum = 0;
	    ArrayList<Integer> maxArray = new ArrayList<Integer>();
	    ArrayList<Integer> newArray = new ArrayList<Integer>();
	    for (Integer i : a) {
	        if (i >= 0) {
	            newSum += i;
	            newArray.add(i);
	        } else {
	            newSum = 0;
	            newArray = new ArrayList<Integer>();
	        }
	        if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
	            maxSum = newSum;
	            maxArray = newArray;
	        }
	    }
	    return maxArray;
	}
}