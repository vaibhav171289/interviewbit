package competition;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(new Solution().solve(sc.nextInt()));
	}
    public int solve(int A) {
        int ans=0;
        long i=1;
        while(i<=A){
        	
            ans+=P(i);
            System.out.println("ans "+ans);
            i+=1;
        }
        int constant = 1000000007;
        return (int)ans%constant;
    }
    public long P(long m){
        long ans=1;
        long k=1;
        while(k<=m){
            if(GCD(k,m)==1){
                ans*=k;
            }
            System.out.println("k "+k +"\tP-ans "+ans);
            k++;
        }
        return (ans%m);
    }
    public long GCD(long k, long m){
        if(m==0) return k;
        else return GCD(m,k % m);
    }
}