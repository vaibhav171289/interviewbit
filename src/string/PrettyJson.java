package string;

import java.util.ArrayList;
import java.util.Scanner;

public class PrettyJson {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> lst = new PrettyJson().prettyJSON(scan.nextLine());
		for(String s:lst)
			System.out.println(s);
	}
	public ArrayList<String> prettyJSON(String a) {
//		System.out.println(a);
		ArrayList<String> lst = new ArrayList<String>();
		int n = a.length();
		int countTab=0;
		String str="";
		for(int i=0;i<n;i++)
		{
			char c=a.charAt(i);
//			System.out.println(c);
			if(c=='[' || c=='{')
			{
				if(str!="")
				{
					lst.add(str);
					str="";
				}
				
				int x= 0;
//				System.out.println("count tab open "+countTab);
				while(x++<countTab)
					str+="\t";
				str+=c;
				countTab++;
				lst.add(str);
				str="";
			}
			else if(c == ']'|| c=='}')
			{
				if(str!="")
				lst.add(str);
				str="";
				countTab--;
//				System.out.println(lst.size());
				int x=countTab;
				while(x-- >0)
					str+="\t";
				str+=c;
//				System.out.println(i+" --- "+c);
//				System.out.println("str "+str);
//				lst.add(str);
//				System.out.println(lst.size());
//				str="";
			}
			else
			{
				int x=countTab;
				String t="";
//				System.out.println("counttab "+countTab);
				while(x-->0 && str=="")
					t+="\t";
					str+=t+c;
					
					if(c==',')
					{
						lst.add(str);
						str="";
					}
			}
		}
		if(str!="")
			lst.add(str);
//		lst.add(a.charAt(a.length()-1)+"");
		return lst;
	}
}
