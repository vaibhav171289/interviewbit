package array;

import java.util.HashMap;

public class WindowString {
	public static void main(String[] args) {
		String S="BAAAAB";
		String T="AAA";
		System.out.println(new WindowString().minWindow(S, T));;
	}
	public String minWindow(String S, String T) {
	    int i=0, j=0;
	    if(S.length()<T.length())
	    return "";
	    HashMap<Character,Integer> patMap = new HashMap<Character,Integer>();
	    for(char c:T.toCharArray())
	    {
	        if(patMap.containsKey(c))
	            {
	                patMap.put(c,patMap.get(c)+1);
	            }
	            else
	            patMap.put(c,1);
	    }
	    int occurence =0 ,start=0,sizeS=S.length(),sizeT=T.length() , minLen= S.length()+1;
	    String res="";
	    HashMap<Character, Integer> strMap= new HashMap<Character,Integer>();
	    for(i=0;i<sizeS;i++)
	    {
	        char c = S.charAt(i);
	        if(patMap.containsKey(c))
	        {
	            if(strMap.containsKey(c))
	            {
	                if(strMap.get(c) <patMap.get(c))
        	        {
        	            occurence++;
        	        }
    	            strMap.put(c,strMap.get(c)+1);
	            }
	            else
	            	{
	            		strMap.put(c,1);
	            		occurence++;
	            	}
	       }
	       if(occurence == sizeT)
	        {
	            char lchar= S.charAt(start);
	            while(!strMap.containsKey(lchar)|| strMap.get(lchar) > patMap.get(lchar))
	            {   
	                if(strMap.containsKey(lchar) &&  strMap.get(lchar) > patMap.get(lchar))
	                    strMap.put(lchar,strMap.get(lchar)-1);
	                    start++;
	                    lchar = S.charAt(start);    
	                
	            	}
	            int window = i-start+1;
	            if(window < minLen)
	            {
	                res = S.substring(start,i+1);
	                minLen = i-start+1;
	            }
	        }
	    }
	    return res;
	}
}
