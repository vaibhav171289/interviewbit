package checkpoint;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciSum {
	private static int n;
	public static BigInteger solveProblem() {
		BigInteger a = BigInteger.valueOf(0), b = BigInteger.valueOf(1), c=a.add(b);
		BigInteger sum=BigInteger.valueOf(0);
        if (n == 0)
            return sum;
        sum.add(c);
        for (; c.compareTo(BigInteger.valueOf(n))<0; )
        {
            c = a.add(b);
            sum.add(c);
            a = b;
            b = c;
        }
        return sum;
	}

//Sample code only. Feel free to change to accept the input described in the problem.

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		/*Parse input here*/
        n = in.nextInt();
        BigInteger sum = solveProblem1();
		System.out.println(sum);
	}
	public static BigInteger solveProblem1() {
	BigInteger fib[] = new BigInteger[n+1];
	fib[0]=BigInteger.valueOf(0);
	fib[1]=BigInteger.valueOf(1);;
	int i=0;
	for( i=2;i<=100000;i++)
	{
		fib[i]=fib[i-1].add(fib[i-2]);
		if(fib[i].compareTo(BigInteger.valueOf(n))>0)
			break;
	}
	BigInteger sum=BigInteger.valueOf(0);
	
	for(int j=0;j<i;j++)
		{
			
			sum=sum.add(fib[j]);
			
		}
	return sum;
	}
}