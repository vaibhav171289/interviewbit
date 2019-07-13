package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LargestNumber implements Comparator<String> {
	public static void main(String[] args) {
		LargestNumber l = new LargestNumber();

		System.out.println(l.largestNumber1(readInput()));
	}

	private static ArrayList<Integer> readInput() {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			lst.add(scan.nextInt());
		}
		return lst;
	}
	//fully accepted
	   public String largestNumber1(final List<Integer> A) {
	        List<String> B = new ArrayList<String>();
	        for (Integer number : A) {
	            String x = number.toString();
	            B.add(x);
	        }
	        Collections.sort(B, this);
	        StringBuilder ans = new StringBuilder();
	        int sum = 0;
	        for (int i = B.size() - 1; i >= 0; i--) {
	            ans.append(B.get(i));
	            sum += Integer.parseInt(B.get(i));
	        }
	        return sum == 0 ? "0" : ans.toString();
	    }

	    public int compare(String a, String b) {
	        String fe = a + b;
	        String se = b + a;
	        return (fe.compareTo(se));
	}
	//partially accepted
    public String largestNumber(final List<Integer> a){
        int n = a.size();
        if(n ==0)return  "";
        String res="";
        List<Integer> result  = new ArrayList<Integer>();
        result.add(a.get(0));
        
        for(int i =1;i < n;i++){
        	int j=0;
        	boolean f =true;
           	  List<Integer> tmp  = result;
           	  int len = tmp.size();
           	  while(j< len && f){
           		  String y = Integer.toString(a.get(i));
           		  String x = Integer.toString(result.get(j++));
           		 f =   compareString(x,y);
           	  }
//           	  System.out.println(f);
           	  
           	  if(!f && j == 1){
           		 result.add(0,a.get(i));
           	  } else if(f && j == len){
           		  result.add(a.get(i));
           	  } else{
           		 result.add(j-1, a.get(i)); 
           	  }
//           	  System.out.println(result);
        	}
        	boolean zero=true;
        	for(int t:result) {
        		if(zero && t==0){
        			
        		}
        		else {
        		    res+=t;
        		    zero = false;
        		}
        	}
        	if(zero)
        		res="0";
//        	System.out.println(res);
    	
    	return res;
    }
    public boolean compareString(String x ,String y){
//    	System.out.println("x "+x+"\t y "+y);
    	String t1 = x+y;
    	String t2 = y+x;
//    	System.out.println("t1 "+t1);
//    	System.out.println("t2 "+t2);
    	int i=0;
    	boolean f1 = true;
    	for( i=0;i<t1.length();){
    		char c1 = t1.charAt(i);
    		char c2 = t2.charAt(i);
    		if(c1==c2) i++;
    		else if(c1 < c2){
    			f1 = false;
    			break;
    		}else break;    			
    	}
    	return f1;
    	
    }
	
}
