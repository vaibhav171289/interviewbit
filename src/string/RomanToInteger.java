package string;

import java.util.HashMap;

public class RomanToInteger {
	public static void main(String[] args) {
		System.out.println(new RomanToInteger().romanToInt("IXL"));
	}
	public int romanToInt(String a) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int size = a.length();
		int val=0;
		for(int i=0;i<a.length();i++)
		{
			int s1 =  map.get(a.charAt(i));
			if(i+1<size)
			{
				int s2= map.get(a.charAt(i+1));
				if(s1>=s2)
				{
					val +=s1;
				}
				else
				{
					val= val-s1;	
					i++;
				}
				System.out.println(val);
			}
			else
			{
				val+=s1;
				i++;
				System.out.println(val);
			}
			System.out.println(val);
		}
		return val;
	}
}
