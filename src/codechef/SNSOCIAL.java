package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class SNSOCIAL {
	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		int t =scan.nextInt();
		while(t-- >0)
		{
			int m = scan.nextInt();
			int n=scan.nextInt();
			int a[][]=new int[m][n];
			for(int i=0;i<m;i++)
				for(int j=0;j<n;j++)
				{
					a[i][j]=scan.nextInt();
				}
			System.out.println(calculateHours(a, m, n)); 
			
		}
		
	}
	public static int calculateHours(int[][]a,int m,int n)
	{
		boolean allEqual=false,allSame=true;
		int count=0;
		
		int temp[][]=  new int[m][n];
		int sum[]= new int[m];
		Arrays.fill(sum, 0);
		while(!allEqual)
		{
//			System.out.println("orginal array");
//			printArray(a, m,n);
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					int max=a[i][j];
					int x=a[i][j];
//					System.out.println("a["+i+"]["+j+"] = "+a[i][j]);
					//west
					if(j>0 && a[i][j-1]>max)
						max=a[i][j-1];
					//north-west
					if(i>0 && j>0 && a[i-1][j-1]>max)
						max=a[i-1][j-1];
					//north
					if(i>0 && a[i-1][j]>max)
						max=a[i-1][j];
					//north-east
					if(i>0 && j<n-1 && a[i-1][j+1]>max)
						max=a[i-1][j+1];
					//east
					if(j<n-1 && a[i][j+1]>max)
						max=a[i][j+1];
					//south-east
					if(i<m-1 && j<n-1 && a[i+1][j+1]>max)
						max=a[i+1][j+1];
					//south
					if(i<m-1 && a[i+1][j]>max)
						max=a[i+1][j];
					//south-west
					if(i<m-1 && j>0 && a[i+1][j-1]>max)
						max=a[i+1][j-1];
					temp[i][j]=max;
					sum[i]+=max;
//					System.out.println("max "+max /*+"  a["+i+"]["+j+"] "+a[i][j]*/);
					if(allSame && max!=x)
						allSame=false;
				}
			}
//			System.out.println("allSame "+allSame);
//			System.out.println("temp array"); 
			
//			printArray(temp, m, n);
			if(!allSame)
				count++;
			allSame=true;
			for(int i=0;i<m-1;i++)
			{
				if(sum[i]!=sum[i+1])
					{
						allEqual=false;
						
						break;
						
					}
				else
					allEqual=true;
			}
			sum=new int[m];
			Arrays.fill(sum, 0);
			a=temp.clone();
		}
		return count;
	}
	private static void printArray(int temp[][],int m,int n)
	{
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			System.out.print(temp[i][j]+" ");
			System.out.print("\n");
		}
	}
}
