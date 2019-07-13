package array;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindTroopsAndKills {

	static int troops=0;
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int m=s.nextInt();
		int a[][]= new int[n][m];
		boolean v[][]= new boolean[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++){
				a[i][j]=s.nextInt();
				v[i][j]=false;
			}
		int kills=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++){
				int res=0;
				if(v[i][j]==false && a[i][j]==1){
					res = find(kills,a,v,i,j,n,m);
				}
				if(res>0) troops++;
				if(kills< res)
					 kills=res;
			}
		System.out.println(troops+" "+kills);
	}
	private static int find(int kills, int[][] a, boolean[][] v, int i, int j, int n, int m) {
		if(i>n-1 || j>m-1 ) return 0;
		else
		if( v[i][j] || a[i][j]==0) {
			
			return 0;
		}else if(!v[i][j] && a[i][j]==1){
			v[i][j]=true;
			kills= 1+find(kills,a,v,i,j+1,n,m)+find(kills,a,v,i+1,j+1,n,m)
			+find(kills,a,v,i+1,j,n,m)+find(kills,a,v,i+1,j-1,n,m);
		}
		
		return kills;
	}
}
