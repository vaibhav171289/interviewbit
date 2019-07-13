package codechef;

import java.util.Scanner;

public class SNELECT {

	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		int n =scan.nextInt();
		scan.nextLine();
		while(n-- >0)
		{
			String str = scan.nextLine();
			int s = 0;
			int m=0;
			for(int i=0;i<str.length();i++)
				if(str.charAt(i)=='s')
					s++;
				else
					m++;
			System.out.println(calc(str,m,s,0));
		}
	}
	
	static String calc(String str,int m,int s,int i) {
		
		for(;i<str.length()-1;)
		{
			if(str.charAt(i)=='s' && str.charAt(i+1)=='m')
			{
				s--;
				i=i+2;
			} else
				if(str.charAt(i)=='m' && str.charAt(i+1)=='s')
				{
					s--;
					i=i+2;
				}
				else
				{
					i++;
				}
		}
		if(s==m)
			return "tie";
		else if(s<m)
			return "mongooses";
		else
		return "snakes";
	}
}
