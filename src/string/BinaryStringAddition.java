package string;

public class BinaryStringAddition {
	public static void main(String[] args) {
		System.out.println(new BinaryStringAddition().addBinary("111", "11"));
	}
	public String addBinary(String a, String b) {
	
		int m = a.length();
		int n = b.length();
		int d=0;
		if(m>n)
		{
			d = m-n;

			for(int i=0;i<d;i++)
			{
				b=0+b;
			}	
		}
		else if(n>m)
		{
			d=n-m;
			for(int i=0;i<d;i++)
			{
				a=0+a;
			}
		}
		String res="";

		char bow = '0';
		for(int i=a.length()-1;i>=0;i--)
		{
			char a1 = a.charAt(i);
			char b1 = b.charAt(i);
			if(a1=='1' && b1=='1')
			{
				if(bow == '1')
				{
					bow='1';
					res = '1'+res;
				}
				else
				{
					bow = '1';
					res = '0'+res;
				}
			}
			else if(a1=='1' || b1=='1')
			{
				if(bow=='1')
				{
					res = '0'+res;
					bow='1';
				}
				else
				{
					res = '1'+res;
					bow='0';
				}
			}
			else {
				if(bow=='1')
				{
					res= '1'+res;
					bow='0';
				}
				else
				{
					res = '0'+res;
					bow='0';
				}
			}
//			System.out.println(i+" --> "+res);
		}
		if(bow=='1')
			res='1'+res;
		
		return res;
	}
}
