package bitManipulation;

public class ReverseBits {
public static void main(String[] args) {
	System.out.println(new ReverseBits().reverse(3));
}
public long reverse(long a) {
	 long rev = 0;

     for (int i = 0; i < 32; i++) {
         rev <<= 1;
         if ((a & (1 << i)) != 0)
             rev |= 1;
     }

     return rev;
}
public long swapBits(long n, int i, int j) {
	long a = (n >> i) & 1;
	System.out.println(n);
	long b = (n >> j) & 1;
// System.out.println(a+"  "+b);
	if ((a ^ b) != 0) {
		return n ^= (1 << i) | (1 << j);
	}
	
	
	return n;
}
}
