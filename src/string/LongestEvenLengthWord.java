package string;

import java.util.StringTokenizer;

public class LongestEvenLengthWord {
	public static void main(String[] args) {
		System.out.println(longestEvenWord("write code for a great time"));
	}
	static String longestEvenWord(String sentence) {

		StringTokenizer str = new StringTokenizer(sentence);
		String maxString="00";
		while(str.hasMoreTokens())
		{
			String s = str.nextToken();
//			System.out.println(s);
			if(s.length()%2==0)
			{
				if(s.length()>maxString.length())
				{
					maxString = s;
				}
			}
		}
		return maxString;

    }
}
