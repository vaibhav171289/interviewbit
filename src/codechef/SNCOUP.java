package codechef;

import java.util.Scanner;

public class SNCOUP {
	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		int t =scan.nextInt();
		while(t-- >0)
		{
			int n=scan.nextInt();
			scan.nextLine();
			String l1 = scan.nextLine().trim();
			String l2=scan.nextLine().trim();
			char a1[] = l1.toCharArray();
			char a2[]= l2.toCharArray();
//			printArray(a1);
//			printArray(a2);
			System.out.println(calculateFences(a1,a2,n));
		}
		
	}

	private static void printArray(char[] a1) {
		// TODO Auto-generated method stub
		for(int i=0;i<a1.length;i++)
			System.out.print(a1[i]+" ");
		System.out.print("\n");
	}

	private static int calculateFences(char[] a1, char[] a2,int n) {
		int countFences=0;
		boolean horizontal=false;
		int prev=-1;
		for(int i=0;i<n-1;i++)
		{
//			System.out.println("i "+i+ "  count "+countFences);
			if(a1[i]=='*' && a2[i]=='*' && !horizontal)
				horizontal=true;
			if(a1[i]=='*' && (a1[i+1]=='*' ||a2[i+1]=='*'))
			{
				countFences++;
			}
			else
			if(a2[i]=='*' && (a1[i+1]=='*' ||a2[i+1]=='*'))
			{
				countFences++;
			}
			else
			{
			while(i+1 <n && (a1[i+1]!='*' && a2[i+1] !='*') )
			{
				i++;
			}
				if(i<n-1)
					countFences++;
			}
			
		}
		
//		System.out.println("vertical countFences "+countFences);
		if(horizontal)
			countFences++;
		return countFences;
	}
}
