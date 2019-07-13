package string;

public class StrStr {
	public static void main(String[] args) {
		System.out.println(new StrStr().strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa"));
	}
public int strStr(final String haystack, final String needle) {
		
		
		if(haystack==null || needle == null)
			return -1;
		if(needle.length()==0)
			return -1;
		int a[]= preprocessing(needle.toCharArray());
		/*for(int i:a)
			System.out.print(i+" ");
		System.out.println();*/
//		System.out.println(haystack.length()-a[a.length-1]);
		return searchSubString(haystack.toCharArray(),needle.toCharArray());
		
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
private int searchSubString(char[] text,char[] pat)
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
			return i-pat.length;
		}
	}
	return -1;
}
}
