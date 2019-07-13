package reportgardencompany;

public class Max_SubContinous_2_arrays {
	int start;
	public static void main(String[] args) {
		new Max_SubContinous_2_arrays();
	}
	public int solution(int[] A, int K, int L) {
		int sum = maxSubArray(A, K,0,A.length);
		System.out.println(sum);
		int s=start,e = start+K;
		int x = maxSubArray(A, L, s, e);
		System.out.println(x);
		int y =  maxSubArray(A, L, s, e);
		System.out.println(y);
		if(x>y)
			return x+sum;
		else
			return y+sum;
	}
	public int maxSubArray(int A[],int k,int s,int e) {
		if (A == null || A.length == 0 || A.length < k)
			return 0;
		int maxSum = Integer.MIN_VALUE, curSum = 0;
		start=0;
		
		for(int i=s;i<k;i++)
			maxSum += A[i];
		
		curSum = maxSum;
		for(int  i=k;i < e;i++)
		{
			curSum +=  A[i] - A[i-k];
			maxSum = Math.max(curSum, maxSum);
			if(maxSum == curSum)
				start = i-k;
		}
		return maxSum;
	}
}
