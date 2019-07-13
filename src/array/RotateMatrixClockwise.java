package array;

import java.util.ArrayList;
import java.util.Scanner;

public class RotateMatrixClockwise {
	public static void main(String[] args) {
		new RotateMatrixClockwise().rotate(readInput());
	}
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
	public void rotate(ArrayList<ArrayList<Integer>> a) {
		int N= a.size();
		 // Consider all squares one by one
	    for (int x = 0; x < N / 2; x++)
	    {
	        // Consider elements in group of 4 in 
	        // current square
	        for (int y = x; y < N-x-1; y++)
	        {
	            // store current cell in temp variable
	            int temp = a.get(x).get(y);
	            
	            
	            // move values from right to top
	            ArrayList<Integer>lst = a.get(x);
	            lst.set(y, a.get(N-1-y).get(x));
	            a.set(x, lst);
	            
	            // move values from bottom to right
	            lst = a.get(N-1-y);
	            lst.set(x, a.get(N-1-x).get(N-1-y));
	            a.set(N-1-y, lst);
	 
	 
	            // move values from left to bottom
	            lst = a.get(N-1-x);
//	            System.out.println(lst);
	            lst.set(N-1-y, a.get(y).get(N-1-x));
//	            System.out.println(lst);
	            a.set(N-1-x, lst);
	 
	            // assign temp to left
	            lst = a.get(y);
	            lst.set(N-1-x, temp);
	            a.set(y, lst);
	        }
	    }
	}
}
