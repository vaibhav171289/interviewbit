package string;

public class LengthLastWord {
	public static void main(String[] args) {
		System.out.println(new LengthLastWord().lengthOfLastWord("   ")); 
		
	}
	public  int lengthOfLastWord(final String a) {
		String b = a.trim();
		if(b.length() == 0)
			return 0;
		int i=b.length()-1;
		int count=0;
		for(;i>0;i--)
		{
			char c = b.charAt(i);
			if(c == ' ')
				{
					count++;
					break;
				}
			
		}
		return b.length()-i-count;
	}
}
