package maths;

public class GridUniquePaths {
	public static void main(String[] args) {
		GridUniquePaths gup  = new GridUniquePaths();
		System.out.println(gup.uniquePaths(15, 15));
	}
	public int uniquePaths(int a, int b) {

		if(a==1 || b==1)
			return 1;
		return uniquePaths(a-1, b)+uniquePaths(a, b-1);
	}
	
}
