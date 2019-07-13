package twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CountTriangles {
	static Scanner scan;
	public static void main(String[] args) {
		System.out.println(new CountTriangles().nTriang(readInput()));
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
	 public int nTriang(ArrayList<Integer> A) {
		    int count=0;
		    
		    if (A == null)
		        return 0;
		    
		    Collections.sort(A);
		    int n = A.size();
		    
		    for (int low = 0; low < n - 2; low++) {
		        
		        int mid = low + 1;
		        int high = n - 1;
		        int sum = A.get(low);
		        
		        while (mid < high) {
		            
		            int num = A.get(mid) + A.get(high);
		            
		            if (num > sum) {
		                
		                while (mid <= high)
		                    mid++;
		                   
		            } else if (num < sum) {
		                mid++;
		            } else {
		                high--;
		            }
		        }
		        count+= mid-low-1;
		    }
		    
		    return count;
		    
		    
			}
		}
