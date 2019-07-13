package maths;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class RankOfString {
	private final long  MOD = 1000003;
	public static void main(String[] args) {
		String str= "acb";
		
		double res= new RankOfString().findIterativeRank(str,0,str.length())+1;
		System.out.println("result "+res);
	}

	public double findIterativeRank(String x,int begin,int end) {
//		System.out.println("begin "+begin +" end "+end);
		
		String a=x.substring(begin, end);
	
		if(a.length()<1)
			return 0;
		
		
//		System.out.println("original string "+a+" == "+a.length());
		HashMap<Character, Integer> target = new HashMap<Character, Integer>();
		
		int sLetter = (int)a.charAt(0);
		/*if(sLetter >=97)
			sLetter = sLetter-97;
		else
			sLetter = sLetter-65;*/
		System.out.println("sletter "+sLetter);
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			
			if (target.containsKey(c)) {
				target.put(c, target.get(c) + 1);
//				System.out.println("multiple occurence " + c + " " + (int) c + " " + (int) sLetter);

				/*if ((int) (c-97) < (int) sLetter) {
					count++;
					
//					System.out.println("---");
				}*/
			} else {
				target.put(c, 1);
//				System.out.println("first occurence " + c + " " + (int) c + " " + (int) sLetter);
				
			}
			if ((int) c < (int) sLetter) {
				count++;
			}
			
			System.out.println("char "+(int)c+" == "+count);
		}
//		System.out.println("count smaller than first letter "+sLetter+" is "+count);
		
		/*for(int i=0;i <rep.length;i++)
		{
			if(rep[i]>0)
			{
				
				System.out.println(((char)(97+i))+" "+i);
			}
		}*/
		double sum = 0,repSum=1;
	/*	if(count>0)
		{
			Iterator it = target.entrySet().iterator();
		while(it.hasNext()) {
			Entry<Character, Integer> entry  = (Entry<Character, Integer>) it.next();
			char key  = entry.getKey();
			int val = entry.getValue();
			
//				System.out.println("key "+key +" val "+val);
				repSum *= fact(val);
		}
		
		}*/
		System.out.println("count "+count);
		System.out.println("fact(a.length()-1) "+(a.length()-1)+"!");
		System.out.println("REPETITION SUM = "+repSum);
//		System.out.println("fact "+fact(a.length()-1));
		sum += (count*(fact(a.length()-1)));
		System.out.println("sum ="+sum);
		return ((sum%MOD)+findIterativeRank(x,begin+1,end)%MOD)%MOD;
	}
	private double fact(int n)
	{
		double fact =1;
		while(n >1)
		{
			fact*=(n);
			n--;
		}
	    return fact;
	}
}
