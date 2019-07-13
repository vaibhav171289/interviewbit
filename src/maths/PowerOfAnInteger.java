package maths;

import java.util.ArrayList;
import java.util.Arrays;

public class PowerOfAnInteger {
	public static void main(String[] args) {
//		System.out.println(new PowerOfAnInteger().isPower(1024000000));
		new PowerOfAnInteger().isPowerOld(1024000000);
	}
	 public boolean isPower( int n)
		{
		    // Base case
		    if (n <= 1) return true;
		    if(n==2 || n==3)
		    return false;
		    ArrayList<Integer> lst = sieve((int)Math.sqrt(n)+1);
		    int t=0;
		    System.out.println(lst);
		    for(int i=0;i<lst.size();i++)
		    {
		        t=n;
		        while(t>0 && t%lst.get(i) ==0)
		        {
		            t=t/lst.get(i);
//		            System.out.println("t / "+t);
		        }
		         t=t/lst.get(i);
		        
		        System.out.println("t "+t+" lst.get(i) "+lst.get(i));
		        if(t==0)
		        return true;
		        
		    }
		    /*// Try all numbers from 2 to sqrt(n) as base
		    for (int x=2; x<=(int)Math.sqrt(n); x++)
		    {
		        long  p = x;
		 
		        // Keep multiplying p with x while is smaller
		        // than or equal to x
		        while (p <= n)
		        {
		            p = (int)p*x;
		            if (p == n)
		                return true;
		        }
		    }*/
			 System.out.println(n);
				
		    return false;
		}
		public ArrayList<Integer> sieve(int a) {
			boolean b[] = new boolean[a + 1];
			Arrays.fill(b, true);
			for (int i = 2; i < b.length; i++) {
				if (b[i] == true) {

					int j = i;
					while ((long) j * i < (long) b.length) {
						b[j * i] = false;

						j++;
					}
					int t = (int) Math.pow(i, 2);
					if (t < b.length)
						b[t] = false;
				}
			}
			ArrayList<Integer> lst = new ArrayList<Integer>();
			for (int i = 2; i < b.length; i++)
				if (b[i] == true)
					lst.add(i);
//	 		System.out.println(lst);
			return lst;
		}
	
	public boolean isPowerOld( int n)
	{
	    // Base case
	    if (n <= 1) return true;
	 
	    // Try all numbers from 2 to sqrt(n) as base
	    for (int x=2; x<=(int)Math.sqrt(n); x++)
	    {
	        int  p = x;
	 
	        // Keep multiplying p with x while is smaller
	        // than or equal to x
	        while (p <= n)
	        {
	            p *= x;
	            if (p == n)
	            {
	            	System.out.println(p+"  "+n);
	            	return true;
	            }
	        }
	    }
	    return false;
	}
}
