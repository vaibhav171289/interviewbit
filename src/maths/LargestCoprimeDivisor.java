package maths;

import java.util.ArrayList;
import java.util.Scanner;


public class LargestCoprimeDivisor {
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
		ArrayList<Integer> lst  =readInput();
		System.out.println(new LargestCoprimeDivisor().cpFact(lst.get(0), lst.get(1)));
	}
    public int cpFact(int A, int B) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        if(gcd(A,B) ==1)
        return A;
        for(int i=2;i<=A/2;i++)
        {
            if(A%i ==0 && B%i !=0)
                factors.add(i);
        }
        
        int res=1;
        System.out.println(factors);
        for(int j=factors.size()-1;j>=0;j--)
        {
            res=factors.get(j); 
            if(gcd(res,B)==1)
                break;
            else 
            	res=1;
        }
        return res;
    }
    private int gcd(int X,int B)
    {
    	while(X >0 && B>0)
    	{
    		System.out.println("X="+X+" B="+B);
        	
        if(X==0)
        return B;
        else if(B==0)
        return X;
        if(X==1 || B==1)
        return 1;
        else
        {
        	int t = X%B;
        	X=B;
        	B=t;
        }
        }

        return 0;
    }
}