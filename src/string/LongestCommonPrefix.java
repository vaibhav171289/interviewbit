	package string;

import java.util.ArrayList;
import java.util.Scanner;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(readInputString()));
	}
	public static ArrayList<String> readInputString()
	{
		ArrayList<String> lst = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();
		scan.nextLine();
		for(int i=0;i<len;i++)
			lst.add(scan.nextLine().trim());
		return lst;
	}
	public String longestCommonPrefix(ArrayList<String> a) {
	if(a.size()<1)
		return "";
	if(a.size() ==1)
		return a.get(0);
	int count=0;
		String s1 = a.get(count++);
		String s2= a.get(count);
		int m=s1.length();
		int n=s2.length();
		String prefix="";
		
		while(count<a.size())
		{
			prefix="";
			for(int i=0;i<m && i<n;i++)
			{
				if(s1.charAt(i) == s2.charAt(i))
					prefix+=s1.charAt(i);
				else
					break;
			}
			count++;
			s1=prefix;
			m=s1.length();
			if(count<a.size())
			{
				s2=a.get(count);
				n=s2.length();
			}
			
		}
		return prefix;
	}
}
