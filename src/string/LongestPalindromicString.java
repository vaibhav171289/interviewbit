package string;

public class LongestPalindromicString {
public static void main(String[] args) {
	System.out.println(new LongestPalindromicString().longestPalindrome("aaaabaaa"));
	
}
public String longestPalindrome(String a) {
	char ar[] = a.toCharArray();
	int max =1,start=0,len= ar.length,low,high;
	//consider each and every character as center point of odd/even palindromes
	for(int i=1;i<len;++i)
	{
		//find longest even length palindrome with i and i-1 as center point
		low=i-1;
		high=i;
		System.out.println("even: ar["+low+"] = "+ar[low] +"  ar["+high+"] = "+ar[high]); 
		
		while(low >=0 && high < len && ar[low] == ar[high])
		{
			System.out.println("even while steps: ar["+low+"] = "+ar[low] +"  ar["+high+"] = "+ar[high]); 
			
			if(high-low +1 >max)
			{
				start=low;
				max=high-low+1;
			}
		
			--low;
			++high;
		}
		//find longest odd length palindrome with i as their center point
		low = i-1;
		high=i+1;
		if(low>=0 && high<len)
		System.out.println("odd: ar["+low+"] = "+ar[low] +"  ar["+high+"] = "+ar[high]); 
		
		while(low >= 0 && high < len && ar[low] == ar[high])
		{
			System.out.println("odd while steps: ar["+low+"] = "+ar[low] +"  ar["+high+"] = "+ar[high]); 
			
			if(high -low +1 > max)
			{
				start = low;
				max=high-low+1;
			}
			--low;
			++high;
		}
	}
	String s="";
	for(int i=start;i<start+max;i++)
		s+=ar[i];
	return s;
}
}
