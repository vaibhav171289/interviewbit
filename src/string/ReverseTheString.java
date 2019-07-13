package string;

public class ReverseTheString {
	public static void main(String[] args) {
		String s = new ReverseTheString().reverseWords("great");
		System.out.println(s);
	}

	public String reverseWords(String a) {
		int i = 0;
		if(a.length()>0)
		{
		char c = a.charAt(i);

		while (c == ' ') {

			c = a.charAt(++i);
		}
		int j = a.length() - 1;
		c = a.charAt(j);
		while (c == ' ')
			c = a.charAt(--j);
		a = a.substring(i, j + 1);
		int size = a.length();
		char ac[] = new char[size + 1];
		for (i = size - 1, j = 0; i >= 0; i--) {
			c = a.charAt(i);
			while (i > 0 && c != ' ') {
				ac[j++] = c;
				c = a.charAt(--i);
			}
			if (i == 0)
				ac[j++] = a.charAt(i);
			// System.out.println(ac[3]+ " j= "+j);
			if (ac[j - 1] != ' ')
				ac[j++] = ' ';
		}

		i = j = 0;
		
		String str = "";
		while (true) {
			while (i<ac.length&& ac[i] != ' ' )
			{
				
				j++;
				i++;
			}
			
			while (j > 0 && ac[j-1]!=' ')
				str += ac[--j];
			str+= " ";
			j = i+1;
			i++;
			if (i > ac.length)
				break;
		}
		
		str = str.trim();
		return str;
		}
		else
			return null;
	}
}
