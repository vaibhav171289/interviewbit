package array;

/**
 * @author vaibhav jain
 * */
/*
 * */
/*
 * 

Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:

		
Input: 	

1 2 3
4 5 6
7 8 9

Return the following :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input : 
1 2
3 4

Return the following  : 

[
  [1],
  [2, 3],
  [4]
]

input format:
m n
values
3 3
1 2 3 4 5 6 7 8 9
*/
import java.util.ArrayList;
import java.util.Scanner;

public class AntiDiagonal {
	public static ArrayList<ArrayList<Integer>> readInput() {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < m; i++) {
			ArrayList<Integer> lst = new ArrayList<Integer>();

			for (int j = 0; j < n; j++) {
				lst.add(scan.nextInt());
			}
			matrix.add(lst);
		}
		return matrix;
	}

	public static void main(String[] args) {
		System.out.println(new AntiDiagonal().diagonal(readInput()));
	}

	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {

		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		int n = a.size();
		int m = a.get(0).size();
		//to iterate over rows
		for (int i = 0; i < n; i++) {
        // to iterate over columns
			for (int j = 0; j < m; j++) {
				//we go to each value and update it to the respective arraylistin matrix
				if (j + i < matrix.size()) {
					lst = matrix.get(j + i);
					lst.add(a.get(i).get(j));
					matrix.set(j + i, lst);
				} else {
					 //insert new value in the array list
					lst = new ArrayList<Integer>();
					lst.add(a.get(i).get(j));
					matrix.add(lst);
				}
			}
		}
		return matrix;
	}
}
