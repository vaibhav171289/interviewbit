package stack_queue;

import java.util.ArrayList;
import java.util.Scanner;

public class EvaluateExpression {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		ArrayList<String> a = new ArrayList<String>();
		for(int i=0;i<size;i++){
			a.add(sc.next());
		}
		System.out.println(new EvaluateExpression().evalRPN(a));
		
	}
	public int evalRPN(ArrayList<String> A) {
		
		Stack<Integer> st = new Stack<Integer>();
		for(String s:A){
			
			char c = s.charAt(0);
			if(s.length()==1 && (c == '+' || c == '-' || c=='/' || c=='*')){
				int m = st.pop();
				int n = st.pop();
				if(c == '+'){
					st.push(m+n);
				}else if(c == '-')
					st.push(n-m);
				else if(c == '*')
					st.push(m*n);
				else if(c == '/')
					st.push(n/m);
			
			}
			else
				st.push(Integer.parseInt(s));
		}
		return  st.pop();
    }
}
