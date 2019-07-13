package array;

import java.util.ArrayList;
import java.util.Scanner;

public class AntiDiagonal {
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
		System.out.println(new AntiDiagonal().diagonal(readInput()));
	}
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {

		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		int n = a.size();
		int m=a.get(0).size();
		for(int i=0;i<n;i++)
		{


			for(int j=0;j<m;j++)
			{
//				System.out.println("j = "+j+" i = "+i +"--> j+i = "+(j+i));
//					System.out.println("matrix size "+matrix.size());
				if(j+i<matrix.size())
				{
					lst= matrix.get(j+i);
					lst.add(a.get(i).get(j));
					matrix.set(j+i, lst);	
				}
					else
						{
						lst= new ArrayList<Integer>();
						

				lst.add(a.get(i).get(j));
				matrix.add(lst);
			}
//				System.out.println(lst);
			}
//			System.out.println("-----------------------");
		}
		return matrix;
	}
}
