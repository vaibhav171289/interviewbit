package maths;

public class ReverseInteger {
public static void main(String[] args) {
	System.out.println(new ReverseInteger().reverse(-1146467285));
}
public int reverse(int a) {
    int num=0;
    boolean neg=false;
    if(a <0)
    neg=true;
    a=Math.abs(a);
    while(a>0)
    {
    	System.out.println(num+"--------"+a);
        int rem = a%10;
        a=a/10;
        if((long)num*10 > Integer.MAX_VALUE || (long)num*10 < Integer.MIN_VALUE)
        return 0;
        	num= (num*10)+rem;
    }
    System.out.println(num+"--------"+a);
    if(neg)
    num= -num;
    
    
    
    return num;
}
}