package string;

public class KMP {
public static void main(String[] args) {
//	String t= "abcabdabcabdabcabdabdabc";
//	String p="abcabdabc";
	String t="aaaaa";
	char c[] = t.toCharArray();
	for(int i=0,j=c.length-1;i<c.length/2;i++,j--)
	{
		char ch = c[i];
		c[i]= c[j];
		c[j]=ch;
	}
	String s="";
	for(char ch:c)
		s+=ch;
	String p = t+"$"+s;
	System.out.println(p);
	KMP kmp = new KMP();
	int a[] = kmp.preprocessing(p.toCharArray());
	for(int i:a)
		System.out.print(i+" ");
	System.out.println();
	System.out.println(t.length()-a[a.length-1]);
	//	kmp.searchSubString(t.toCharArray(),p.toCharArray());
	
}
private int[] preprocessing(char[] pat)
{
	int i=0,j=-1;
	int b[] = new int[pat.length+1];
	b[i]=j;
	while(i < pat.length)
	{
		while( j>= 0 && pat[i] != pat[j])
		{
//			System.out.println(c+++"-->pat["+i+"]="+pat[i]+"  pat["+j+"]="+pat[j]);
			
			j=b[j];
//			System.out.println("j--> "+j);
		}
//		if(j>=0)
//		System.out.println(c+++"-->pat["+i+"]="+pat[i]+"  pat["+j+"]="+pat[j]);
		
		i++;
		j++;
		b[i]=j;
//		System.out.println("i "+i+" j "+j + " --> b["+i+"] "+b[i]);
	}
	
	return b;
}
private void searchSubString(char[] text,char[] pat)
{
	int i=0,j=0;
	int b[]= preprocessing(pat);
	while( i<text.length)
	{
		while(j>= 0 && text[i]!=pat[j])
		{
			j=b[j];
		}
		i++;
		j++;
		if(j == pat.length)
		{
			System.out.println("found substring at: "+(i-pat.length));
			j=b[j];
		}
	}
}
}
