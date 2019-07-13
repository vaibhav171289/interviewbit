package string;

public class MinimumCharacterPalindrome {
	public static void main(String[] args) {
		int res= new MinimumCharacterPalindrome().solve("hqghumeaylnlfdxfi");
		System.out.println(res);
	}
	 public int solve(String A) {
	
		 return insert(A.toCharArray(), 0, A.length()-1);
	    }
	 
	 int insert(char A[], int i,int j){
		if(i>j) return Integer.MAX_VALUE;
		if(i == j ) return 1;
		if(i == j-1) return (A[i]==A[j]?0:1);
		
		return (A[i]==A[j])?insert(A,i+1,j-1):Math.min(insert(A,i+1,j),insert(A,i,j-1))+1;
	 }
	 
	 public int solve1(String A)
	 {
		 int i=0, j= A.length()-1;
		 int count=0;
		 while(i<=j)
		 {
			 if(A.charAt(i)!=A.charAt(j))
				 count=count+2;
			 i++;
			 j--;
		 }
		 if(A.length()%2==0)
			 count--;
		 
//		 System.out.println("i "+i +" j "+j);
		 return count;
	 }
}
