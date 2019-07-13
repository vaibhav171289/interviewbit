package stack_queue;

import java.util.Scanner;

public class GenerateAllParentheses {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		System.out.println(new GenerateAllParentheses().isValid(s));

	}
	public int isValid(String A) {
		Stack<Character> s = new Stack<Character>();
		for(Character c:A.toCharArray()){
			if(s.isEmpty())
				s.push(c);
			else{
				char top = s.peek();
				if(c == '(' || c == '{' || c == '[')
					s.push(c);
				else
				if(top == '(' && c == ')')
					s.pop();
				else if(top == '{' && c == '}')
					s.pop();
				else if(top == '[' && c == ']')
					s.pop();
				else
					return 0;
			}
		}
		if(s.isEmpty())
			return 1;
		return 0;
	}
}
