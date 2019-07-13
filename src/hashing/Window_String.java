/**
 * 
 */
package hashing;

/**
 * @author vaibhav jain
 * Working Solution
 *
 */
/*
 * 

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.

Example :

S = "ADOBECODEBANC"
T = "ABC"

Minimum window is "BANC"

    Note:

        If there is no such window in S that covers all characters in T, return the empty string ''.
        If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).


 * */
import java.util.HashMap;
import java.util.Scanner;

public class Window_String {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	
		String S = scan.nextLine();
		String T= scan.nextLine();
		Window_String w =  new Window_String();
		System.out.println(w.minWindow(S,T));
	}
	public String minWindow(String S, String T) {
		int i = 0;
		if (S.length() < T.length())
			return "";
		HashMap<Character, Integer> patMap = new HashMap<Character, Integer>();
		//create a pattern map to store the count of all the characters in the T string
		for (char c : T.toCharArray()) {
			if (patMap.containsKey(c)) {
				patMap.put(c, patMap.get(c) + 1);
			} else
				patMap.put(c, 1);
		}
		int occurrence = 0, start = 0, sizeS = S.length(), sizeT = T.length(), minLen = S.length() + 1;
		String res = "";
		HashMap<Character, Integer> strMap = new HashMap<Character, Integer>();
		//now start matching all the characters in the S string.
		for (i = 0; i < sizeS; i++) {
			char c = S.charAt(i);
			if (patMap.containsKey(c)) { // we only consider it if String T contains this character
				if (strMap.containsKey(c)) {  // if same character repeats itself in S then
					               // check this count should not be greater than the count in S
					if (strMap.get(c) < patMap.get(c)) {
						occurrence++;
					}
					strMap.put(c, strMap.get(c) + 1);
				} else {
					strMap.put(c, 1);
					occurrence++;
				}
			}
//we have found a window which contains all the charaters of String T
			if (occurrence == sizeT) {
				char lchar = S.charAt(start);
//now we need to trim it to minimum length where all the character of string T
//by removing the characters to the last occurrence of the next character from string T 
				while (!strMap.containsKey(lchar) || strMap.get(lchar) > patMap.get(lchar)) {    
					if (strMap.containsKey(lchar) && strMap.get(lchar) > patMap.get(lchar))
						strMap.put(lchar, strMap.get(lchar) - 1);
					start++;
					lchar = S.charAt(start);
				}
				int window = i - start + 1;
				if (window < minLen) {
					res = S.substring(start, i + 1);
					minLen = i - start + 1;
				}
			}
		}
		return res;
	}
}
