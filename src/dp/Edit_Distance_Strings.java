package dp;

public class Edit_Distance_Strings {
public static void main(String[] args) {
	String s1 = "sunday";
	String s2 = "saturday";
	System.out.println(minOps(s1,s2));
}
static int minOps(String s1, String s2){
	int m  = s1.length();
	int n = s2.length();
	int dp[][] = new int[m+1][n+1];
	for(int i=0;i<=m;i++)
		for(int j=0;j<=n;j++){
			if(i==0)
				dp[i][j]=j;
			else if(j==0)
				dp[i][j]=i;
			else if(s1.charAt(i-1) == s2.charAt(j-1))
				dp[i][j]=dp[i-1][j-1];
			else
				dp[i][j] = 1+ min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]);
		}
	return dp[m][n];
}
static int min(int x,int y ,int z ){
	if(x<y && x<z) return x;
	else if(y<x && y<z) return y;
	else
		return z;
}
}
