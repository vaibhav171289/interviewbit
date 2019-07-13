package competition;

import java.util.Arrays;
import java.util.Scanner;

public class SimplestSum {
	static int simplestSum(int k, int a, int b) {
		long ar[] = new long[b + 1];
		Arrays.fill(ar, 0);
		long sum = 0;
		for (int i = a; i <= b; i++) {
			while(i<=k)
			{
				sum+=k;
				i+=k;
			}
			if(i<ar.length )
			if ( ar[i] > 0) {
				sum += ar[i];
				sum=sum%1000000007;
			} else {
				for (int i1 = 1; i1 <= i; i1 += 1) {

					sum += i1%1000000007;
					sum=sum%1000000007;
					ar[i1] = sum;
					i1 *= k;
				}

			}
			
		}

		return (int) (sum%1000000007);
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int q = in.nextInt();
	        for(int a0 = 0; a0 < q; a0++){
	            int k = in.nextInt();
	            int a = in.nextInt();
	            int b = in.nextInt();
	            int result = simplestSum(k, a, b);
	            System.out.println(result);
	        }
	        in.close();
	    }
	}
