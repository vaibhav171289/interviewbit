package checkpoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfMedian_kth_smallest {

	public int kthSmllest(final List<Integer> a, int k)
	{
		int med = medianOfMedian(a, k);
		int pos  =partition(a,med);
		
		if(pos==k-1)
			return a.get(pos);
		else if(pos<k-1)
			return kthSmllest(a, k);
		else
		return kthSmllest(a, k);
	}
	private int partition(List<Integer> a, int med) {
		int i=0;
		
		for(;i<a.size();i++)
		{
			if(a.get(i)==med)
			break;
		}
		swap(a,i,a.size()-1);
		i=0;
		for(int j=0;j<a.size();j++)
		{
			if(a.get(j)<=med)
				swap(a, i, j);
			i++;
		}
		swap(a,i,a.size()-1);
		return i;
	}
	private void swap(List<Integer> a, int i, int j) {
		
		int t = a.get(i);
		a.set(i, a.get(j));
		a.set(j,t);
	}
	public int medianOfMedian(List<Integer> a,int k)
	{

		if(k>0 && k<a.size())
		{
			int n=a.size();
			int i=0;
			ArrayList<Integer> med= new ArrayList<Integer>();
			int j=0;
			for(;i<n;i++)
			{
				med.add(i);
				if((i+1)%5==0)
				{
					a.set(j++, findMedian(med));
					med.clear();
				}
				
			}
			a.set(j, findMedian(med));
			a.subList(0, j);
			System.out.println(a);
			int medofMed=0;
			if(a.size()>1)
				medianOfMedian(a, k);
			else
				return a.get(0);
			
		}
		return 0;
	}
	private int findMedian(ArrayList<Integer> a) {
		Collections.sort(a);
		int pos= a.size()/2;
		return a.get(pos);
	}
}
