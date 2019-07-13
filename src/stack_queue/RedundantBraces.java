package stack_queue;

import java.util.Scanner;

public class RedundantBraces {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t-->0){
			String A = sc.nextLine();
			System.out.println(A+"===>"+new RedundantBraces().braces(A));
		}
	}
	
	public int braces(String A) {
		Stack<Character> st = new Stack<Character>();
		int open=0,close=0;
		for(int i=0;i<A.length();i++){
			char c = A.charAt(i);
			if(c == '('){
				st.push(c);
				open++;
			}else if(c == ')'){
				int count=0;
				close++;
				while(!st.isEmpty() && st.peek() != '(' ){
					st.pop();
					count++;
				}
				if(!st.isEmpty())
					st.pop();
				if(count==0) return 1;
				
			}
			else{
				if(c == '+' || c== '-' || c =='*'|| c == '/')
				st.push(c);
			}
		}
		if(open == close) return 0;
		while(!st.isEmpty() && (st.peek() != '(' || st.peek() != ')'))
			st.pop();
		if(!st.isEmpty() || (open != close))
			return 1;
    return 0;
	}
}
