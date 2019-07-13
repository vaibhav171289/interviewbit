package trees;

import java.util.ArrayList;
import java.util.HashMap;

public class MorseCode {
    private static HashMap<String,Character> pattern;
    public static void main(String[] args) {
		pattern= new HashMap<String,Character>();
		pattern.put("..",'a');
		pattern.put("-", 'b');
		pattern.put("-.", 'c');
		pattern.put(".-", 'd');
		pattern.put("-..", 'e');
		pattern.put(".-.", 'f');
		
		String s= "..-..";
		                 
		int maxdepth=3;
		ArrayList<ArrayList<String>> a= new ArrayList<>();
		for(int i=0;i<s.length();i++)
			a.add(new ArrayList<String>());
		int i=1;
		String substr=s.substring(0, i);
		
		while(!pattern.containsKey(substr)){
			i++;
			substr=s.substring(0, i);
		}
		ArrayList<String> x = a.get(i-1);
		x.add(pattern.get(substr) + "");
		a.set(i-1, x);
		
		for(;i<s.length();i++){
			int j=i+1;
			ArrayList<String> l = a.get(i-1);
			
			while(j<= s.length() && j<=i+maxdepth){
				 substr = s.substring(i, j);
//				System.out.println(substr);
			   if(pattern.containsKey(substr)){
				  fill(l,a,pattern.get(substr),j-1);
			   }
			   j++;
			}
		}
		System.out.println(a.get(s.length()-1));
	}
    private static void fill(ArrayList<String> l,ArrayList<ArrayList<String>> a,char c,int j){
    	ArrayList<String> k = a.get(j);
//    	System.out.println(c);
    	for(int i=0;i<l.size();i++){
    		String p = l.get(i);
    		k.add( p+c);
    	}
//    	System.out.println(a);
    }
}
