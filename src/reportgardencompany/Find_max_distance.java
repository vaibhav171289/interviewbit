package reportgardencompany;

import java.util.Arrays;
import java.util.Scanner;


public class Find_max_distance {
private static Scanner scan;
public static void main(String[] args) {
	scan = new Scanner(System.in);
	int n =  scan.nextInt();
	int A[] =  new int[n];
	for(int i=0;i<n;i++)
		A[i] = scan.nextInt();
    Find_max_distance m =  new Find_max_distance();
    m.solution(A);
}
public int solution(int[] A) {
   if(A.length<2) return -2;
   Arrays.sort(A);
   int min=100000000;
   for(int i=0;i<A.length;i++)
	   for(int j=i+1;j<A.length;j++) {
		   int p  = A[i];
		   int q = A[j];
		   int d = Math.abs(p-q);
		   System.out.println("p : "+p +"\tq: "+q+"\td: "+d);
		   System.out.println("i: "+i+"\tj: "+j);
		   int index =-1;
		   if(d > 1) {
		      index = Arrays.binarySearch(A, d);
		      if(index < 0 ) {
		    	  if(d<min)
		    	  min = d;
		      } else
		    	  j = A.length;
		   }else
			   if(d < min)
		      min = d;
		   System.out.println("min == "+min);
		   if(j < A.length-1 && A[j+1] != A[j])
			   j = A.length;
	   }
   if(min>100000000) return -1;
   return min;	
}
}
