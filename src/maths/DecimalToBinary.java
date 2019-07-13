package maths;

public class DecimalToBinary {
	public static void main(String[] args) {
		DecimalToBinary db = new DecimalToBinary();
		db.findDigitsInBinary(38);
	}
	public String findDigitsInBinary(int a) {
	    String s="";
	    /*if(a==1)
	    return "1";*/
	    int i=1,pos=0;
	    while(a>=i*2)
	    {
	       pos++;
	        i=i*2;
	    }
	   // System.out.println(pos);
	    int b=a;
	    
	    while(pos>=0)
	    {
	        int t=(int)Math.pow(2,pos);
	       // System.out.println(t+"----"+b);
	        if(b>=t)
	        {
	            s+="1";
	        
	        b=b-(t);
	            
	        }
	        else
	        s+="0";
	        pos--;
	    }
	    return s;
	}
}