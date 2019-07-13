package dp;

import java.util.ArrayList;
import java.util.Scanner;

public class K_Subset {
	public static void main(String[] args) {
		K_Subset sub = new K_Subset();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int k = sc.nextInt();
		int s = sc.nextInt();
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		sub.printSubsets(a, n, s, k);
			
	}
	void printArray(boolean dp[][]){
	  for(int i=0;i<dp.length;i++){
    	   for(int j=0;j<dp[i].length;j++){
    		   System.out.print(dp[i][j]+" | ");
    	   }
    	   System.out.print("\n");
       }
	}
	void printSubsets(int a[], int n, int sum,int k) {
		if(n==0 || sum<0 || k>n) return ; // getting a subset is not possible in these conditions
		boolean dp [][] = new boolean[n][sum+1];
		for (int i=0; i<n; ++i) 
        { 
            dp[i][0] = true;   
        } 
       
        // Sum a[0] can be achieved with single element if k=1 
        if (a[0] <= sum ) 
           dp[0][a[0]] = true; 
//        printArray(dp);
        // Fill rest of the entries in dp[][] 
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < sum + 1; ++j){
//            	System.out.println("a[i]="+a[i]+"\tj="+j);
                if(a[i] <= j) {
                	dp[i][j] = (dp[i-1][j] || 
                
                                           dp[i-1][j-a[i]]); 
                }else{
//                	System.out.println("dp["+(i-1)+"]["+j+"]="+dp[i-1][j]);
                	dp[i][j]=dp[i - 1][j];
                }
//                System.out.println("i="+i+"\tj="+j+"\tdp="+dp[i][j]);
            }
        }
        printArray(dp);
        if (dp[n-1][sum] == false) 
        { 
            System.out.println("There are no subsets with" +  
                                                  " sum "+ sum); 
            return; 
        } 
       
        // Now recursively traverse dp[][] to find all 
        // paths from dp[n-1][sum] 
        ArrayList<Integer> p = new ArrayList<>(); 
        printSubsetsRec(a, n-1, sum, p,dp, k); 
	}
	private void printSubsetsRec(int[] a, int i, int sum, ArrayList<Integer> p,boolean dp[][], int k) {
		if(p.size()>k) {
			p.clear();
			return;
		}
		// If we reached end and sum is non-zero. We print 
        // p[] only if a[0] is equal to sum OR dp[0][sum] 
        // is true. 
        if (i == 0 && sum != 0 && dp[0][sum]) 
        { 
            p.add(a[i]); 
            if(p.size() == k)
              display(p); 
            p.clear(); 
            return; 
        } 
       
        // If sum becomes 0 
        if (i == 0 && sum == 0 ) 
        { 
        	if(p.size() == k)
               display(p); 
            p.clear(); 
            return; 
        } 
       
        // If given sum can be achieved after ignoring 
        // current element. 
        if (dp[i-1][sum]) 
        { 
            // Create a new vector to store path 
            ArrayList<Integer> b = new ArrayList<>(); 
            b.addAll(p); 
            printSubsetsRec(a, i-1, sum, b,dp, k); 
        } 
       
        // If given sum can be achieved after considering 
        // current element. 
        if (sum >= a[i] && dp[i-1][sum-a[i]]) 
        { 
            p.add(a[i]); 
            printSubsetsRec(a, i-1, sum-a[i], p,dp, k); 
        } 
		
	}
	void display(ArrayList<Integer> v) 
    { 
       System.out.println(v); 
    } 
}
