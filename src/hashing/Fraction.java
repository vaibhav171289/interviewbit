package hashing;

import java.util.HashMap;
import java.util.Scanner;

public class Fraction {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		System.out.println("result->"+new Fraction().fractionToDecimal(A, B));
	}

	public String fractionToDecimal(int A, int B) {
		HashMap<Long,Integer> m= new HashMap<>();
		String res="";
		boolean sign=false;
		if((A<0 && B>0)||(A>0 && B<0)) sign =true;
		Long A1=Math.abs(Long.parseLong(Integer.toString(A)));
	    Long B1= Math.abs(Long.parseLong(Integer.toString(B)));
//		System.out.println(A1+","+B1);
		Long q= A1/B1;
		res+=q;
//		System.out.println("quo "+q);
		if(q==0L &&sign)res="-"+res;
		Long rem= A1%B1;
		String dec="";
//		System.out.println("rem "+rem);
		Long n=Math.abs(rem)*10L;
		
//		System.out.println("n "+n);
		int index=0;
		if(rem!=0L)
			res+=".";
		boolean rep=false;
		while(rem!=0L){
			rem=n%B;
//			System.out.println("rem--> "+rem);
//			System.out.println(n);
			q=n/B;
			q =Math.abs(q);
//			System.out.println(q);
			n=rem*10;
			
			if(m.containsKey(rem)){
				int i = m.get(rem);
				if(Character.getNumericValue(dec.charAt(i)) != q.intValue()){
					dec+=q;
					m.put(rem, i+1);
				}
				rep=true;
				break;
			}
			dec+=q;
			m.put(rem,index);
			index++;
//			System.out.println("dec "+dec);
		}
		
		if(rep){
			index = m.get(rem);
			int size =dec.length();
			res+=dec.substring(0,index)+"("+dec.substring(index,size)+")";
		}
		else
			res+=dec;

		return res;
	}
}
