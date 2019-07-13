package bitManipulation;

public class NumberOf1s {
	public static void main(String[] args) {
		System.out.println(new NumberOf1s().numSetBits(21));
	}
	public int numSetBits(long a) {
		int c=0;
		while(a>0)
		{
			a &= a-1;
				c++;
		}
		return c;
	}
}
