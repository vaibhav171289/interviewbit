package stack_queue;

import java.util.ArrayList;
import java.util.Scanner;

public class NearestSmallerElement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			lst.add(sc.nextInt());
		}
		System.out.println(new NearestSmallerElement().prevSmaller(lst));
	}
	public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
		Stack<Integer> st = new Stack<Integer>();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for(int v:A){
			if(st.isEmpty()){
				lst.add(-1);
				st.push(v);
			}else{
				while(!st.isEmpty() && st.peek() >= v){
					st.pop();
				}
				if(!st.isEmpty() && st.peek() < v){
					lst.add(st.peek());
				}else{
					lst.add(-1);
				}
				st.push(v);					
			}
		}
		return lst;
	}
}
