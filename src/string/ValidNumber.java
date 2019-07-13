package string;

public class ValidNumber {
public static void main(String[] args) {
	System.out.println(new ValidNumber().isNumber("0.e1"));
}
	public int isNumber(final String a) {

		
		String s = a.trim();
		if(s.length() ==0 )
			return 0;
		int m =s.length();
		char []c = s.toCharArray();
		boolean onedot =true,oneExp = true;
		boolean oneMinus =true;
		for(int i=0;i<m;i++)
		{
//			System.out.println(i+" --> "+c[i]+ " == "+(int)c[i]);
			 if(c[i] == '.')
			{
				if(onedot && i !=m-1 && oneExp)
					onedot=false;
				else
				return 0;
//				System.out.println(i+" --> "+onedot);
			}
			else if(c[i] == 'e')
			{
				if(i>0 && oneExp && i != m-1 && (c[i-1]>48&&c[i-1]<57))
					oneExp=false;
				else
					return 0;
			}
			else if(c[i] == '-')
			{
				if(i!=0 && oneMinus)
					oneMinus =false;
				else if(i!=0 && !oneMinus)
					return 0;
//					System.out.println(i+" --> "+oneMinus);
			}
			else
				if((c[i] <48 || c[i]>57) && c[i]!='e')
			{
				return 0;
			}
		}
		
		return 1;
	}
}
