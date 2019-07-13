package twopointers;

import java.util.ArrayList;
import java.util.Scanner;

public class _2Duplicates_sorted_array {
	public static void main(String[] args) {
		System.out.println(new _2Duplicates_sorted_array().removeDuplicates(readInput()));
	}
	private static ArrayList<Integer> readInput() {

		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			lst.add(scan.nextInt());
		}
		return lst;
	}

public int removeDuplicates(ArrayList<Integer> A) {
	    
	    int index = 1;
	    int count = 1;
	    int n = A.size();
	    
	    for (int i = 1; i < n; i++) {
	        if (A.get(i).intValue() == A.get(i - 1).intValue() && count < 2) {
	            A.set(index, A.get(i));
	            count++;
	            index++;
	        } else if (A.get(i).intValue() != A.get(i - 1).intValue()) {
	            A.set(index, A.get(i));
	            count = 1;
	            index++;
	        }
	    }
	    
	    
	    return index;
	}
}
