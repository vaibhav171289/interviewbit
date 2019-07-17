package array;

/**
 * @author vaibhav jain
 * */
/*
 * 

Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

    NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
    For example, for this problem, following are some good questions to ask :

    1.  Q : Can the input have 0’s before the most significant digit. 
            Or in other words, is 0 1 2 3 a valid input?
    2.  A : For the purpose of this question, YES
    3.  Q : Can the output have 0’s before the most significant digit? Or in other words,
            is 0 1 2 4 a valid output?
    4.  A : For the purpose of this question, NO. Even if the input has zeroes before
            the most significant digit.

*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AddOneToNumber {
	private static ArrayList<Integer> readInput() {
		/*
		 * Input style 5 1 2 3 4 5
		 */
		Scanner scan = new Scanner(System.in);
		// size of the list
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			// followed by values
			lst.add(scan.nextInt());
		}
		return lst;
	}

	public static void main(String[] args) {
		System.out.println(new AddOneToNumber().plusOne(readInput()));
	}

	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		int val = 0;
		ArrayList<Integer> lst = new ArrayList<Integer>();
		int count = 0;
 // remove 0's from the start and capture the index in the list
		for (int n : a)
			if (n == 0) {
				count++;
			} else
				break;
		int i = a.size() - 1;
		val = a.get(i) + 1;
// increment the last index and if greater than we need to adjust the overflow
		if (val > 9)
 // always check your end of array before adjusting the overflow value 
			while (val > 9 && i > 0) {
// since we are alwasy adding 1 , value cannot be greater than 10,
//so we add 0 to the list and increment the previous value by 1 
				lst.add(0);
				a.set(i - 1, a.get(i - 1) + 1);
//check the same cycle for all the digits in the list
				val = a.get(i - 1);
				i--;
			}
		else {
			lst.add(val);
			i--;
		}
/*2 cases : 
         1. value at last i i.e index 0 is 10
	     2. or simply copy the value the remaining values
*/	
		for (; i >= count; i--) {
			if (a.get(i) == 10 || val == 10) {
				lst.add(0);
				lst.add(1);
			} else
				lst.add(a.get(i));
		}

		if (lst.isEmpty())
			lst.add(1);
//reverse the list to return the result
		Collections.reverse(lst);
		return lst;
	}
}
