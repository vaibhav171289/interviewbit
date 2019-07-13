package twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class _3_sum_zero {
	static Scanner scan;
	public static void main(String[] args) {
		System.out.println(new _3_sum_zero().threeSum(readInput()));
	}
	private static ArrayList<Integer> readInput() {

		 scan = new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			lst.add(scan.nextInt());
		}
//		System.out.println(lst);
		return lst;
		
	}
public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
	    
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    
	    if (A == null)
	        return res;
	    
	    Collections.sort(A);
	    int n = A.size();
	    
	    for (int low = 0; low < n - 2; low++) {
	        
	        int mid = low + 1;
	        int high = n - 1;
	        int sum = -A.get(low);
	        
	        if (low > 0 && A.get(low).intValue() == A.get(low - 1).intValue())
	            continue;
	        
	        while (mid < high) {
	            
	            int num = A.get(mid) + A.get(high);
	            
	            if (num == sum) {
	                temp.add(A.get(low));
	                temp.add(A.get(mid));
	                temp.add(A.get(high));
	                res.add(temp);
	                temp.clear();
	                
	                int prev = mid;
	                while (mid <= high && A.get(mid).intValue() == A.get(prev).intValue())
	                    mid++;
	                    
	            } else if (num < sum) {
	                mid++;
	            } else {
	                high--;
	            }
	        }
	    }
	    
	    return res;
	    
	    
	}
}
