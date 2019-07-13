package string;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	int m= scan.nextInt();
	scan.nextLine();
	String a[]= new String[m];
	for(int i=0;i<m;i++)
		{
			String s= scan.nextLine();
//			System.out.println("-->"+s);
			a[i]=s;
		}
	int n = scan.nextInt();
	scan.nextLine();
	String b[]= new String[n];
	for(int i=0;i<n;i++)
	{
		b[i]=scan.nextLine().trim();
	}
	int c[] = getMinimumDifference(a, b);
	for(int i:c)
		System.out.println(i);
	}
	static int[] getMinimumDifference(String[] a, String[] b) {
		int res[] = new int[a.length];
		for(int i=0;i<a.length;i++)
		{
			String s1= a[i];
			String s2= b[i];
//			System.out.println("--->"+s1.length());
//			System.out.println("--->"+s2.length());
			if(s1.length() != s2.length())
				res[i]=-1;
			else
			{
				HashMap<Character, Integer> stringMap = new HashMap<Character,Integer>();
				for(int j=0;j<s1.length();j++)
				{
					char c = s1.charAt(j);
//					System.out.println("==="+c); 
					
					if(stringMap.containsKey(c))
					stringMap.put(c, stringMap.get(c)+1);
					else
						stringMap.put(c, 1);
				}
//				System.out.println(stringMap.size()); 
				
				int count=0;
				for(int j=0;j<s2.length();j++)
				{
					char c= s2.charAt(j);
//					System.out.println(c);
					if(stringMap.containsKey(c) )
					{
						stringMap.put(c, stringMap.get(c)-1);

						if(stringMap.get(c)<0)
						{
							stringMap.remove(c);
							count++;
						}
					}
					else
						count++;
				}
				
//				System.out.println(count);
				res[i]=count;
			}
		}
		return res;

    }
}
