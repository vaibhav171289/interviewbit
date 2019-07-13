package string;

import java.util.HashMap;
import java.util.Scanner;

public class Integer_To_Roman {
private static Scanner scan;
public static void main(String[] args) {
	scan  = new Scanner(System.in);
	int num = scan.nextInt();
	Integer_To_Roman in = new Integer_To_Roman();
	System.out.println(in.intToRoman(num));
}
public String intToRoman(int A) {
	
	HashMap<Integer,Character> map = new HashMap<>();
	map.put(1,'I');
	map.put(5,'V');
	map.put(10,'X');
	map.put(50,'L');
	map.put(100,'C');
	map.put(500,'D');
	map.put(1000,'M' );
	int num = A,pos =1000;
	String s="";
	while(num >0){
		int rem = num/pos;
		num = num%pos;
		if(pos == 1000 && rem >0 ){
			while(rem-->0)
				s+=map.get(pos);
		}
		else if(pos == 100 && rem >0){
			if(rem == 9){
				s+="CM";
			}else if(rem ==4)
				s+="CD";
			else
			{
				if(rem >=1 && rem <= 3)
				{
					while(rem-- >0)
						s+="C";
				} else
				{
					rem = rem-5;
					s+="D";
					
					while(rem -->0)
						s+="C";
					
				}
			}
		}
		else if(pos == 10 && rem >0) {
			if(rem == 9){
				s+="XC";
			}else if(rem ==4)
				s+="XL";
			else
			{
				if(rem >=1 && rem <= 3)
				{
					while(rem-- >0)
						s+="X";
				} else
				{
					rem = rem-5;
					s+="L";
					
					while(rem -->0)
						s+="X";
					
				}
			}
		}
		else if(pos == 1 && rem >0) {
			if(rem == 9){
				s+="IX";
			}else if(rem ==4)
				s+="IV";
			else
			{
				if(rem >=1 && rem <= 3)
				{
					while(rem-- >0)
						s+="I";
				} else
				{
					rem = rem-5;
					s+="V";
					
					while(rem -->0)
						s+="I";
					
				}
			}
		}
		pos=pos/10;
	}
return  s;
}
}
