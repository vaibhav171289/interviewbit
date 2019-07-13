package dp;

import java.util.ArrayList;
import java.util.Scanner;


public class LongestCommonSubsequence {
public static void main(String[] args) {
	System.out.println(new LongestCommonSubsequence().longestIncreasingSubsquence(readInput()));
/*		ArrayList<Integer> lst = readInput();
		int size = lst.size();
		int a[] = new int[size];
//		System.out.println("size "+size);
		System.out.println(lst);
		for(int i=0;i<size;i++)
			a[i]=lst.get(i);
		new LongestCommonSubsequence().findSubsequence(a);
*/}
private static ArrayList<Integer> readInput()
{
	Scanner scan = new Scanner(System.in);

	ArrayList<Integer> lst = new ArrayList<Integer>();
	String s[]= scan.nextLine().split(",");
	int size = s.length;
	for(int i=0;i<size;i++)
	{
		lst.add(Integer.parseInt(s[i].trim()));
	}
	return lst;
}
public void findSubsequence(int[] arrA) {
	//complexity is n^2 with dynamic problem
	
	int[] LIS = new int[arrA.length];
	for (int i = 0; i < arrA.length; i++) {
		int max = -1;
		for (int j = 0; j < i; j++) {
			// check if previous elements > current element
			if (arrA[i] > arrA[j]) {
				// update the max from the previous entries
				if (max == -1 || max < LIS[j] + 1) {
					max = 1 + LIS[j];
				}
			}
		}
		if (max == -1) {
			// means none of the previous element has smaller than arrA[i]
			max = 1;
		}
		LIS[i] = max;
	}
	for(int i:LIS)
		System.out.print(i+" ");
	System.out.println();
	// find the max in the LIS[]
	int result = -1;
	int index = -1;
	for (int i = 0; i < LIS.length; i++) {
		if (result < LIS[i]) {
			result = LIS[i];
			index = i;
		}
	}
	// Print the result
	// Start moving backwards from the end and
	String path =  arrA[index] + " ";
	int res = result-1;
	for (int i = index-1; i >= 0; i--) {
		if(LIS[i]==res){
			path =  arrA[i] + " " + path;
			res--;
		}			
	}
	System.out.println("Longest Increasing subsequence: " + result);
	System.out.println("Actual Elements: " + path);		
}

	
	private int longestIncreasingSubsquence(ArrayList<Integer> a)
	{
		int size = a.size();
				
		int [] tabletail  =new int[size];
		int max=1;
		tabletail[0] = a.get(0);
		for(int i=1;i<size;i++)
		{
			if(a.get(i)<tabletail[0])
				tabletail[0]=a.get(i);
			else if(a.get(i)>tabletail[max-1])
			{
				tabletail[max++]=a.get(i);
			}
			else
			{
				int index= ceilIndex(tabletail,-1,max-1,a.get(i));
				System.out.println("index "+index + "  table[" +index+"]="+tabletail[index]);
				tabletail[index]=a.get(i);
			}
			for(int j=0;j<tabletail.length;j++)
				System.out.print(tabletail[j]+" ");
			System.out.println();
		}
		for(int i=0;i<tabletail.length;i++)
			System.out.print(tabletail[i]+" ");
		System.out.println();
		return max;
	}
	private int ceilIndex(int[] tabletail, int i, int j, Integer key ) {
		while(j-i >1)
		{
			int m=i+(j-i)/2;
			System.out.println(tabletail[m]+"===="+key);
			if(tabletail[m]>=key)
				j=m;
			else
				i=m;
		}
		return j;
	}
}
