package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SetMatrixZeros {
	public static ArrayList<ArrayList<Integer>> readInput()
	{
		Scanner scan= new Scanner(System.in);
int m=scan.nextInt();
int n=scan.nextInt();
ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

for(int i=0;i<m;i++)
{
	ArrayList<Integer> lst = new ArrayList<Integer>();

	for(int j=0;j<n;j++)
	{
		lst.add(scan.nextInt());
	}
	matrix.add(lst);
}
		return matrix;
	}
	public static void main(String[] args) {
		new SetMatrixZeros().setZeroes(readInput());
	}
	void printArray(ArrayList<ArrayList<Integer>> a)
	{
		for(int i=0;i<a.size();i++)
		{
			for(int j=0;j<a.get(i).size();j++)
		
			{
				System.out.print(/*"i = "+i+" j = "+j +" val = "+*/a.get(i).get(j)+" ");
			}
			System.out.println();
		}
		System.out.println("---------------");
	}
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
//		printArray(a);
		ArrayList<Integer> rowSum  =new ArrayList<Integer>();
		ArrayList<Integer> colSum = new ArrayList<Integer>();
		for(int i=0;i<a.size();i++)
		{
			int rowsum=0;
			for(int j=0;j<a.get(i).size();j++)
			{
				rowsum += a.get(i).get(j);
			}
			rowSum.add(rowsum);
		}
		for(int i=0;i<a.get(0).size();i++)
		{
			int colsum=0;
			for(int j=0;j<a.size();j++)
			{
				colsum+=a.get(j).get(i);
			}
			colSum.add(colsum);
		}
//		System.out.println("row sum "+rowSum);
//		System.out.println("col sum "+colSum); 
		for(int i=0;i<rowSum.size();i++)
		{
//			System.out.println(rowSum.get(i)+"-->"+a.get(i).size());
			if(rowSum.get(i)!=a.get(i).size())
			{
				ArrayList<Integer> tmp = new ArrayList<Integer>(a.size());
				for(int j=0;j<a.get(i).size();j++)
					tmp.add(0);
				a.set(i, tmp);
			}
		}
//		printArray(a);
		for(int i=0;i<colSum.size();i++)
		{
//			System.out.println(colSum.get(i)+"--->"+a.size());
			if(colSum.get(i) != a.size())
			{
				for(int j=0;j<a.size();j++)
				{
					ArrayList<Integer> tmp= a.get(j);
					tmp.set(i, 0);
					a.set(j, tmp);
				}
			}
		}
//		printArray(a);
	}
}
