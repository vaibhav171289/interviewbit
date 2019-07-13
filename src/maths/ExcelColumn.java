package maths;

import java.util.ArrayList;

public class ExcelColumn {
	public static void main(String[] args) {
		ExcelColumn ec = new ExcelColumn();
		System.out.println(ec.titleToNumber("ABC"));
	}
	public int titleToNumber(String a) {
		
		    int n = a.length();
		    
		    ArrayList<Character> s = new ArrayList<Character>(26);
		    for(int i=0;i<26;i++)
		    {
		        s.add((char)(65+i));
		        
		    }
//		    System.out.println(s);
		  
		    int val=0;
		    int count =n;
//		    System.out.println("count "+count);
		    for(int i=0;i<n;i++)
		    {
		        val += Math.pow(26,count-1)*(s.indexOf((char)(a.charAt(i)))+1);
//		        System.out.println("val "+i+" = "+val);
		        count--;
		    }
		    return val;
		}
	}