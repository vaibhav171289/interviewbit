package string;

public class CompareVersion {
	public static void main(String[] args) {
		System.out.println(new CompareVersion().compareVersion("1.0.2", "1.0.2.0.3"));
	}
	public int compareVersion(String a, String b) {
		
		int size=0;
		String l1 [] = a.split("\\.");
		String l2[] = b.split("\\.");
		int m = l1.length;
		int n= l2.length;
		
		if(m < n)
			size = m;
		else
			size=n;
		for(int i=0;i<size;i++)
		{
//			System.out.println(l1[i]+" == "+l2[i]);
			String s1 = l1[i];
			String s2 = l2[i];
//			if(i==0)
			{
				int k=0;
				while(k<s1.length() && s1.charAt(k) == '0')
					k++;
				s1=s1.substring(k, s1.length());
				k=0;
				while(k<s2.length() && s2.charAt(k) == '0')
					k++;
				s2=s2.substring(k, s2.length());
			}
//			if(!s1.isEmpty() && !s2.isEmpty())
//			System.out.println("after removing 0's: "+s1+"--"+s2);
			if(s1.length() > s2.length() )
			{
				return 1;
			}
			else if(s1.length() < s2.length())
			{
				return -1;
			}
			else
			{
				
//				if(s1.isEmpty() && s2.isEmpty())
//				{
//					return 0;
//				}
				for(int j=0;!s1.isEmpty()&&j<s1.length();j++)
				{
					int x = s1.charAt(j);
					int y= s2.charAt(j);
					if(x > y)
						return 1;
					else if(y>x)
						return -1;
				}
			}
		}
		if(m>n)
		{
			int k=b.length();
			while(k<a.length() && (a.charAt(k)=='0' || a.charAt(k) == '.'))		
			{

				k++;
			}
			if(k<a.length())
				return 1;
			
		}
		else if(n>m)
		{
			int k=a.length();
			while(k<b.length() && (b.charAt(k)=='0' || b.charAt(k) == '.'))		
			{

				k++;
			}
			if(k<b.length())
				return -1;
		}
		
		return 0;
	}
}
