package string;

public class CountSay {
	public static void main(String[] args) {
		System.out.println(new CountSay().countAndSay(1));
	}
	public String countAndSay(int a) {
		if(a==0)
			return null;
		String val ="1";
		String res="";
		while(--a>0)
		{
//			System.out.println("--------"+a+"-----------");
			char [] c =val.toCharArray();
			int i=0;
			for(int j=0;j<c.length;j++)
			{
				int count=1;
				
			while(i<c.length-1 && c[i]==c[i+1])
			{
				count++;
				i++;
				j++;
			}
//			System.out.println("count "+count+ "--> "+i);
			res += count+""+c[i];
//			System.out.println("val  "+val +"  res "+res );
			i++;
			}
			val=res;
			res="";
			
		}
		return val;
	}
}
