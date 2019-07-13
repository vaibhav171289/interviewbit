package array;

import java.util.Scanner;

public class RowMaximum_1 {
public static void main(String[] args) {
	Scanner scan= new Scanner(System.in);
	int m = scan.nextInt();
	int n = scan.nextInt();
	int a[][] = new int[m][n];
	for(int i=0;i<m;i++)
		for(int j=0;j<n;j++)
		{
			a[i][j]=scan.nextInt();
		}
	/*for(int i = 0;i<m;i++)
	{
		for(int j=0;j<n;j++)
	
			System.out.print(a[i][j]+" ");
		System.out.println();
	}*/
		System.out.println(new RowMaximum_1().rowWithMax1s(a));
}
public int rowWithMax1s(int a[][])
{
	int max_row_index=0,max=-1;
	for(int i=0;i<a.length;i++)
	{
		int index = first(a[i],0,a[i].length-1);
		if(index != -1 && a[i].length-1-index >max)
		{
			max= a[i].length-1-index;
			max_row_index = i;
					
		}
				
	}
	return max_row_index;
}
private int first(int[] a, int low, int high) {
	// TODO Auto-generated method stub
	if(low<=high)
	{
		int mid = (low+high)/2;
		if((mid==0||a[mid-1]==0) &&a[mid]==1)
		return mid;
		else if(a[mid]==0)
		 return first(a,mid+1,high);
		else
			return first(a,low,mid-1);
	}
	return -1;
}
}
