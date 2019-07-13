package array;

import java.util.Arrays;

/**
 *  M x N matrix with cell value as either 0 or 1.
 *  A connection between two cells is possible if value of both cells is 1.
 *  You need to count the total no. of possible connections. */
public class FindConnections {
	public static void main(String[] args) {
		int a[][]= new int[4][4];
		a[0][0] = 1;a[0][1] = 1;a[0][2] = 1;a[0][3] = 1;
		a[1][0] = 1;a[1][1] = 1;a[1][2] = 1;a[1][3] = 1;
		a[2][0] = 1;a[2][1] = 1;a[2][2] = 1;a[2][3] = 1;
		a[3][0] = 1;a[3][1] = 1;a[3][2] = 1;a[3][3] = 1;
		boolean b[][] = new boolean[4][4];
		for(int i=0;i<4;i++)
		Arrays.fill(b[i], true);
		for(int i[]:a){
			for(int j:i)
				System.out.print(j+" ");
			System.out.println();
		}
		System.out.println(countConn(a,0,0,4,4,b));
	}

	private static int countConn(int[][] a, int i, int j, int m, int n,boolean b[][]) {
		int x=0,y=0;
//		System.out.println(i+" | "+j);
		if(b[i][j] == true  && i<m-1 && j < n-1){
			b[i][j] = false;
			if( a[i][j] == 1 && a[i][j] == a[i+1][j]){
				x = 1+ countConn(a, i+1, j, m, n,b);
//				System.out.println("match x "+ x );	
			}
			else x = countConn(a, i+1, j, m, n,b);
			if(a[i][j] == 1 && a[i][j] == a[i][j+1]){
				y= 1 +countConn(a, i, j+1, m, n,b);
//				System.out.println("match y "+ x );	
			}
			else y = countConn(a, i, j+1, m, n,b);
//			System.out.println(x+"==>"+y);
			return x+y;
		}else if(b[i][j] == true  &&  i<m && j < n-1){
			b[i][j] =false;
//			System.out.println(i+" | "+j+"==>"+a[i][j]);
			if(a[i][j] == 1 && a[i][j] == a[i][j+1])
			return 1+countConn(a, i, j+1, m, n,b);
			else
				return countConn(a, i, j+1, m, n,b);
		}
		else if( b[i][j] == true  && i<m-1 && j<n){
			b[i][j] = false;
//			System.out.println(i+" | "+j+"=+++=>"+a[i][j]);
			if(a[i][j] == 1 && a[i][j] == a[i+1][j] )
			return 1+countConn(a, i+1, j, m, n,b);
			else
				return countConn(a, i+1, j, m, n,b);
		}
			
		else return 0;
	}
}
