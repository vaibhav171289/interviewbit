package binarysearch;

import java.util.List;

public class CountOccurence {
	public int findCount(final List<Integer> a, int b) {
		
		return 0;
	}
	private int search(List<Integer> a,int b,int i,int j)
	{
		int mid= (i+j)/2;
		if(i <=j)
		{
			int count =0;
			if(a.get(mid) == b)
			{
				count++;
				int k=mid;
				while(a.get(k--) == b)
					count++;
				k=mid+1;
				while(a.get(k++)==b)
					count++;
				return count;
			}
			else if(a.get(mid)>b)
				return search(a,b,i,mid);
			else
				return search(a,b,mid+1,j);
		}
		
		return 0;
			
	}
/*	 if(a.get(i)<=a.get(j))
		    return a.get(i);
		  //  System.out.println("mid "+a.get(mid));
			int next= (mid+1)%a.size();
			int prev = (mid+a.size()-1)%a.size();
// 			System.out.println("next "+a.get(next)+" prev "+a.get(prev));
			if(a.get(mid) <= a.get(next) && a.get(mid) <= a.get(prev))
			{
			    return a.get(mid);
			}
			 if(a.get(mid)<=a.get(j))
				return search(a,i,mid);
			else
				return search(a,mid+1,j);*/
}
