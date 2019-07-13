package stack_queue;

import java.util.Scanner;

public class SimplifyDirPath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();
		System.out.println("result==>"+new SimplifyDirPath().simplifyPath(path));
	}
	public String simplifyPath(String A) {
		String [] str = A.split("/");
		Stack<String> st = new Stack<String>();
		for(String s:str){
			
			if(s.isEmpty()) continue;
			System.out.println(s);
			if(s.equalsIgnoreCase("..") && !st.isEmpty()){
				st.pop();
			}
			else if(!s.equalsIgnoreCase(".") && !s.equalsIgnoreCase("..")){
				System.out.println(s);
				st.push(s);
			}
		}
		String r="";
		if(st.isEmpty() )
			return "/";
		while(!st.isEmpty()){
			String x = st.pop();
			if(!x.isEmpty())
				r= "/"+x+r;
//			System.out.println(x+"===>"+r);
		}
		return r;
	}
}
