package array;

import java.util.ArrayList;

public class PascalTriangle {
	public static void main(String[] args) {
		System.out.println(new PascalTriangle().generate(5));
	}
	public ArrayList<ArrayList<Integer>> generate(int a) {
	
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		lst.add(1);
 		triangle.add(lst);
		for(int i=1;i<a;i++)
		{
			lst = new ArrayList<Integer>();
			ArrayList<Integer> tmp = triangle.get(i-1);
				lst.add(1);
			for(int j=0;j<i-1;j++)
			{
				{
					lst.add(tmp.get(j)+tmp.get(j+1));
				}
			}
			lst.add(1);
			triangle.add(lst);
		}
		return triangle;
	}

}
