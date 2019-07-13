package binarysearch;

import java.util.ArrayList;

public class AllocateBooks {
	public int books(ArrayList<Integer> a, int b) {
			long sum=0;
			int n=	a.size();
			if(n<b)
			return -1;
			for(int i=0;i<a.size();i++)
				sum+=a.get(i);
			
			long start = 0 ,end =sum;
			long result= Long.MAX_VALUE;
			while(start<=end)
			{
				long mid = (start+end)/2;
				if(isPossible(a,n,b,mid))
				{
					result = Math.min(result,mid);
					end= mid-1;
				}
				else
				{
					start = mid+1;
				}
			}
		return (int)result;
	}

	private boolean isPossible(ArrayList<Integer> a, int n, int m, long cur_min) {

		int students = 1;
		long cur_sum =0;
		for(int i=0;i<n;i++)
		{
			if(a.get(i) >cur_min)
			return false;
			if(cur_sum+a.get(i) > cur_min)
			{
				students++;
				cur_sum = a.get(i);
				if(students > m)
					return false;
			}
			else
					cur_sum+=a.get(i);
		}
		return true;
	}
	
}
