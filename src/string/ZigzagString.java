package string;

import java.util.Arrays;

public class ZigzagString {
	public static void main(String[] args) {
		System.out.println(new ZigzagString().convert("geeksforgeeks", 5));
	}
	public String convert(String a, int b) {
		if(b==1)
			return a;
	String str="";
	String s[]=new String[b];
	Arrays.fill(s, "");
	int row=0;
	boolean down=true;
	for(int i=0;i<a.length();i++)
	{

		s[row] = s[row]+a.charAt(i);
//		System.out.println("s["+row+"] = "+s[row]);
		if(row == b-1)
		{
			down=false;
		}
		else
		if(row == 0)
		{
			down=true;
		}
		if(down)
			row++;
		else
			row--;
			
	}
	for(String s1:s)
		str+=s1;
		return str;
	}
}
