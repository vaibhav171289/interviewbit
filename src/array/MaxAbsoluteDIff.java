package array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class MaxAbsoluteDIff {
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
		MaxAbsoluteDIff m = new MaxAbsoluteDIff();
		ArrayList<Integer>lst= readInput();
		System.out.println(m.maxArra(lst));
		System.out.println(m.maxArr(lst));
	}
	
	public int maxArr(ArrayList<Integer> A)
	{
		int n=A.size(),max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE,max4=Integer.MIN_VALUE,ans=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
		    max1=Math.max(max1,A.get(i)+i);
		    max2=Math.max(max2,-A.get(i)+i);
		    max3=Math.max(max3,A.get(i)-i);
		    max4=Math.max(max4,-A.get(i)-i);
		}
		for(int i=0;i<n;i++){
		    ans=Math.max(ans,max1-A.get(i)-i);
		    ans=Math.max(ans,max2+A.get(i)-i);
		    ans=Math.max(ans,max3-A.get(i)+i);
		    ans=Math.max(ans,max4+A.get(i)+i);
		}
		return ans;
	}
	public int maxArra(ArrayList<Integer> A) {
		int size= A.size();
		int a[][]=new int[size][size];
		for(int i=0,j=0;i<size && j<size;i++,j++)
			a[i][j]=0;
		for(int i=0;i<size;i++)
			{
			for(int j=i+1;j<size;j++)
			
			{
//				System.out.println("a["+i+"]["+j+"]--> "+a[i][j]+" ");
				int sum = Math.abs(A.get(i)-A.get(j))+Math.abs(i-j);
				a[i][j]=a[j][i]=sum;
			}
//			System.out.print("\n");
			}
		int max=0;
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++)
				{
					if(max<(int)a[i][j])
						max=(int)a[i][j];
//					System.out.println("a["+i+"]["+j+"]--> "+a[i][j]+" ");
				}
//			System.out.print("\n");
		}
		return max;
	}
}