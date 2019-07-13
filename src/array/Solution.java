package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	private static ArrayList<Integer> readInput()
	{
		String s="asdf";
		Character.isLetterOrDigit(s.charAt(0) );
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
	System.out.println(new Solution().solve(readInput()));
}
	public int solve(ArrayList<Integer> A) {
		
		Collections.sort(A);
		 System.out.println(A);
		 int key=0;
		 if(A == null || A.size()==0)
		 return -1;
		 if(A.size()%2==0)
		  key=A.size()/2;
		  else
		  key=(A.size()+1)/2;
//		 System.out.println("key "+key);
		 return BS(A,0,A.size(),key);
		 
	        
	    }
	public static  int BS(ArrayList<Integer> a,int s,int e,int mid)
	{
		
	    System.out.println(s+"--->"+e);
	    
		if(s < e)
		{
		   	mid = (s+e)/2;
		    System.out.println("ele "+a.get(mid)+ " mid " +mid);
		    System.out.println("key --> "+(a.size()-mid-1));
		   


		     if(a.get(mid) == (a.size()-mid-1))
		     {
		    	 for(int j=mid+1;j<a.size();j++)
		    	 {
		    		 System.out.println("j ===="+a.get(j));
		    		 if(a.get(mid) == a.get(j))
		    	 
		    			 return -1;
		    	
		    	 }
		    	 return 1;

		     }
   		    	    else	
			if(a.get(mid)>(a.size()-mid-1))
			{
			
			    return BS(a,s,mid,mid);
			}
	
			else if(a.get(mid)<(a.size()-mid-1))
			{
				// mid=(s+(e-s))/2;
				 return BS(a,mid+1,e,mid);
			}
		
		
		}
			return -1;
	}
}
