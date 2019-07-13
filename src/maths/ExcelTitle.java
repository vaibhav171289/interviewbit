package maths;


public class ExcelTitle {
	public static void main(String[] args) {
		ExcelTitle col = new ExcelTitle();
		col.convertToTitle(731);
	}
		public String convertToTitle(int a) {
			 
			    String str= "";
			    while(a>0)
			    {
			    	int rem = a%26;
			    	if(rem ==0)
			    	{
			    		str+='Z';
			    		a= a/26 -1;
			    	}
			    	else
			    	{
			    		str+= (char)((rem-1)+(int)'A');
			    		a=a/26;
			    	}
			    }
			    String res = new StringBuffer(str).reverse().toString();
			    
			    
			    return res;
		}
	}

