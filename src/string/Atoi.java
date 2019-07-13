package string;

public class Atoi {
	public static void main(String[] args) {
		System.out.println(new Atoi().atoi("- 5 88C340185Q  71  8079 834617385 2898422X5297Z6900"));
		
	}
	public int atoi(final String a) {
		int m = a.length();
		int i=0;
		while(i<m && a.charAt(i) == ' ')
		{
			i++;
		}
		String res="";
		boolean positive=true;
		boolean negative=true;
		for(;i<m;i++)
		{
			if(a.charAt(i) >=48 && a.charAt(i) <=57)
			{
				res= res +a.charAt(i);
				if(Long.parseLong(res) > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				if(Long.parseLong(res)<Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
			}
			else if(a.charAt(i) == '+')
			{
				if(positive)
					positive=false;
				else break;
			}
			else if(a.charAt(i) == '-')
			{
				if(negative)
					{
						negative=false;
						res = res+'-';
					}
				else break;
			}
			else
				break;
			
			
		}
		if(res.isEmpty() || res.equals("-"))
			return 0;
		return  Integer.parseInt(res);
	}
}
