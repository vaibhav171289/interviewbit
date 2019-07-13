package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class MedianArray {
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		int i=0,j=0;
		if(a==null && b == null)
			return -1;
		int m =a.size();
		int n=b.size();
		
		if(a==null || m==0)
		{
			if(n%2 == 0)
				return (double)(b.get(n/2)+b.get((n/2 -1)))/2;
			else
				return b.get(n/2);
		}
		else if(b== null || n ==0)
		{
			if(m%2 == 0)
				return (double)(a.get(m/2)+a.get(m/2 -1))/2;
			else
				return a.get(m/2);
		}
		else
		{
			int size = m+n;
			int mid1 = m/2;
			int mid2 = n/2;
//			System.out.println("a mid "+a.get(mid1));
//			System.out.println("b mid "+b.get(mid2));
			if(size%2==0)
			{
				/*
				ArrayList<Integer> l1 = new ArrayList<Integer>();
				l1.add(a.get(mid1-1));
				l1.add(a.get(mid1));
				ArrayList<Integer> l2 = new ArrayList<Integer>();
				l2.add(b.get(mid2-1));
				l2.add(b.get(mid2));*/
				if(m>1 && n >1 && a.get(mid1)<b.get(mid2) && a.get(mid1)>b.get(mid2-1) && a.get(mid1-1)<b.get(mid2-1))
				{
					return (a.get(mid1)+b.get(mid2-1))/2;
				}
				else if(m > 1 && n> 1 &&a.get(mid1)>b.get(mid2) && b.get(mid2) > a.get(mid1-1)&& b.get(mid2-1)>a.get(mid1-1))
				{
					return (b.get(mid2-1)+b.get(mid2))/2;
				} 
				else if(m > 1 && n> 1 && a.get(mid1)<b.get(mid2) && a.get(mid1)>b.get(mid2-1) && a.get(mid1-1) > b.get(mid2-1))
				{
					return ( a.get(mid1-1)+a.get(mid1))/2;
				}
				else if(m > 1 && n> 1 && m%2==0 && n%2==0 && a.get(mid1)>b.get(mid2) && a.get(mid1-1)<b.get(mid2) && a.get(mid1-1)>b.get(mid2-1))
				{
					return (a.get(mid1-1)+b.get(mid2))/2;
				}
				/*else
					if(a.get(mid1)<b.get(mid2) && a.get(mid1)>b.get(mid2-1) && a.get(mid1-1)<b.get(mid2-1))
					*/{
						return (a.get(mid1)+b.get(mid2))/2;
					}
				
//				return findMedianSortedArrays_old(l1,l2);
			}
			else
			{
				if(a.get(mid1)<b.get(mid2))
					return a.get(mid1);
				else
					return b.get(mid2);
			}
		}
	}
	public double findMedianSortedArrays_old(final List<Integer> a, final List<Integer> b) {
	
		List<Integer> merge = new ArrayList<Integer>();
		int i=0,j=0;
		int m=0,n=0;
		if(a!=null)
		    m=a.size();
		if(b!=null)
		    n=b.size();
		int cur=0,count=0,med=0;
		int size = m+n;
			med=size/2;
		
		if(n>0 && m>0)
		if(a.get(i)<a.get(j))
		{
			cur=a.get(i);
			i++;
			
		}
		else
		{
			cur=a.get(j);
			j++;
		}
		int next=0;
		while(count<med)
		{
			next=cur;
			if(a.get(i)<b.get(j))
			{
				cur = a.get(i);
				i++;
			}
			else
			{
				cur=b.get(j);
				j++;
			}
			count++;
		}
		
		
		/*	while(i<m && j<n)
		{
			if(a.get(i)<b.get(j))
			{
				merge.add(a.get(i));
				i++;
			}
			else
			{
				merge.add(b.get(j));
				j++;
			}
		}
		while(i<m)
		{
			merge.add(a.get(i));
			i++;
		}
		while(j<n)
		{
			merge.add(b.get(j));
			j++;
		}
		int size= merge.size();
		double med=0.0;*/
		System.out.println("cur "+cur);
		System.out.println("next "+next);
		if(size%2==0)
		{
			return (double)(cur+next)/2;
		}
		else
		return (double)(cur/2);
	}
}
