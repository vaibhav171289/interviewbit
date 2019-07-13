package binarysearch;

import java.util.List;

public class RotatedSortedArray {
	public int binarySearch_method_2(int[] nums, int left, int right, int target){
	    if(left>right) 
	        return -1;
	 
	    int mid = left + (right-left)/2;
	 
	    if(target == nums[mid])
	        return mid;
	 
	    if(nums[left] <= nums[mid]){
	        if(nums[left]<=target && target<nums[mid]){
	          return binarySearch_method_2(nums,left, mid-1, target);
	        }else{
	          return  binarySearch_method_2(nums, mid+1, right, target);
	        }
	    }else {
	        if(nums[mid]<target&& target<=nums[right]){
	          return  binarySearch_method_2(nums,mid+1, right, target);
	        }else{
	          return  binarySearch_method_2(nums, left, mid-1, target);
	        }
	    }
	}
	public int search(final List<Integer> a, int b) {
	    if(a==null || a.size()==0)
	    return 0;
	    if(a.size()==1)
	    return a.get(0) == b?0:-1;
	    int index =0;
	    if(a.get(0) >a.get(a.size()-1))
	  {
	      index= searchIndex(a,0,a.size()-1, b);
	   // System.out.println(index);
	    if(a.get(index) ==b)
	    {
	     return index;   
	    }
	    else
	    if(a.get(index)<b && a.get(0) <b)
	    return bsearch(a,0,index-1,b);
	    else
	    return bsearch(a,index,a.size()-1,b);
	  }
	  else
	  return bsearch(a,0,a.size()-1,b);
	}
	private int searchIndex(List<Integer> a,int i,int j ,int b)
	{
	
		if(i <j)
		{
		    	int mid= (i+j)/2;
		   
	 if(a.get(i)<=a.get(j))
		    return i;
		  //  System.out.println("mid "+a.get(mid));
			int next= (mid+1)%a.size();
			int prev = (mid+a.size()-1)%a.size();
// 			System.out.println("next "+a.get(next)+" prev "+a.get(prev));
			if(a.get(mid) <= a.get(next) && a.get(mid) <= a.get(prev))
			{
			    return mid;
			}
			 if(a.get(mid)<=a.get(j))
				return searchIndex(a,i,mid,b);
			else
				return searchIndex(a,mid+1,j,b);
		 
		}
		
		return -1;
			
	}
		private int bsearch(List<Integer> a,int i,int j,int b)
	{
		int mid= (i+j)/2;
		if(i <j)
		{
		  //  System.out.println(a.get(mid));
			if(a.get(mid) == b)
			{
		
				return mid;
			}
			else if(a.get(mid)>b)
				return bsearch(a,i,mid,b);
			else
				return bsearch(a,mid+1,j,b);
		}
		
		return -1;
			
	}
}
