package rippling;

import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */

class lets_do
{
     static long arr[][][] = new long[10][1801][301];
     static long inf = 1000000007;
    public static long noofways(int L,int R, int B)
        {
            if(R < 0 || R > 1801)
                return 0;
            
            if(arr[L][R][B] > -1)
            return arr[L][R][B];
            
            if(B == 0)
            {
                if(R == 0)
                {
                    arr[L][R][B] = 1;
                     return 1;
                }
                   arr[L][R][B] = 0;
                return 0;
            }
            long anscount = 0 ;
            
            if(L > 0)
            {
                anscount = (anscount +noofways(L-1,R,B-1)%inf)%inf;
            }
            if(R!=0)
            {
                anscount =(anscount+noofways(L,R-4,B-1)%inf +noofways(L,R-6,B-1)%inf)%inf;
            }
            anscount = (anscount+noofways(L,R,B-1)%inf)%inf;
            arr[L][R][B] = anscount;
            return anscount;
            
            
        }

	public static void main (String[] args) throws java.lang.Exception
	{
	   Scanner s= new Scanner(System.in);
    	int T;
        T = s.nextInt();
    	int R,B,L;
    	
    	  for(int i =0  ;i < 10 ;i++)
    	   {
    	       for(int j =0  ; j < 1801 ;j++)
    	       {
    	           for(int k =0 ; k < 301; k++)
    	            arr[i][j][k] = -1;
    	       }
    	   }
    	while(T-- > 0)
    	{
    	   R =  s.nextInt();
    	   B =  s.nextInt();
    	   L =  s.nextInt();
        	 if(R>1800 || R%2==1)
            {
                 System.out.println(0);
                continue;
            }
    	   
    	  System.out.println(noofways(L,R,B));
    	}
    	
  
	}
}