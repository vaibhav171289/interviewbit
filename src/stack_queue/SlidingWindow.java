package stack_queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SlidingWindow {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> A = new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			A.add(sc.nextInt());
		}
		int B= sc.nextInt();
		System.out.println(new SlidingWindow().slidingMaximum(A, B));
		
	}
	void print(Deque<Integer> d,List<Integer>A){
		for(Integer x:d)
			System.out.print(A.get(x)+" ");
		System.out.println("\n---------------------------");
		
	}
	public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {

        // Create a Double Ended Queue, Qi that will store indexes of array elements 
        // The queue will store indexes of useful elements in every window and it will 
        // maintain decreasing order of values from front to rear in Qi, i.e.,  
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order 
        Deque<Integer> Qi = new LinkedList<Integer>(); 
          
        /* Process first k (or first window) elements of array */
        ArrayList<Integer> lst = new ArrayList<Integer>();
        int i; 
        for(i = 0; i < B; ++i) 
        { 
            // For very element, the previous smaller elements are useless so 
            // remove them from Qi 
            while(!Qi.isEmpty() && A.get(i) >= A.get(Qi.peekLast())) {
             
            	Qi.removeLast();   // Remove from rear 
            }
              
            // Add new element at rear of queue 
            Qi.addLast(i); 
        } 
        print(Qi,A);
        // Process rest of the elements, i.e., from arr[k] to arr[n-1] 
        for( ;i < A.size(); ++i) 
        { 

            // The element at the front of the queue is the largest element of 
            // previous window, so print it 
        	lst.add(A.get(Qi.peek()));
              
            // Remove the elements which are out of this window 
            while((!Qi.isEmpty()) && Qi.peek() <= i-B) 
                Qi.removeFirst(); 
              
            // Remove all elements smaller than the currently 
            // being added element (remove useless elements) 
            while((!Qi.isEmpty()) && A.get(i) >= A.get(Qi.peekLast())) 
                Qi.removeLast(); 
              
  
            // Add current element at the rear of Qi 
            Qi.addLast(i); 
            print(Qi,A);

        } 
        lst.add(A.get(Qi.peek()));
          return lst;
	}
	//using stacks
	public ArrayList<Integer> slidingMaximum1(final List<Integer> A, int B) {
        int max=Integer.MIN_VALUE;
        ArrayList<Integer> lst = new ArrayList<Integer>();
        Stack<Integer> s1= new Stack<Integer>();
        Stack<Integer> s2= new Stack<Integer>();
        
        int i=0;
        while(i<B){
        	s1.push(A.get(i++));
        }
//        System.out.println("s1 size in start "+s1.size());
        for(;i<A.size();){
//        	System.out.println("----------------------------");
//        	System.out.println(A.get(i));
			if (!s1.isEmpty()) {
//				System.out.println("s1 size "+s1.size());
				if(i<A.size()){
					s2.push(A.get(i++));
				}
				if (s1.size() == B) {
					while (s1.size() != 1) {
						int v = s1.pop();
						if (v > max) {
							max = v;
						}
						s2.push(v);
					}
					int v = s1.pop();
					if (v > max) {
						max = v;
					}
					lst.add(max);
//					System.out.println("s1 max  "+max);
					max=Integer.MIN_VALUE;
				}else{
					s1.push(A.get(i++));
				}
			}else{
//				System.out.println("s2 size "+s2.size());
				if (s2.size() == B) {
					int v = s2.pop();
					if (v > max) {
						max = v;
					}
					while (!s2.isEmpty()) {
						v = s2.pop();
						if (v > max) {
							max = v;
						}
//						System.out.println("s2 v "+v);
						s1.push(v);
					}
					lst.add(max);
//					System.out.println("s2 max  "+max);
					max=Integer.MIN_VALUE;
					if(i<A.size()){
						s1.push(A.get(i++));
					}
				}else{
					s2.push(A.get(i++));
				}
			}
        }
        max=Integer.MIN_VALUE;
        if(!s1.isEmpty()){
	        while(!s1.isEmpty()){
	        	int v = s1.pop();
//	        	System.out.println("last  s1 "+v);
				if (v > max) {
					max = v;
				}
	        }
	        lst.add(max);
        }
        max=Integer.MIN_VALUE;
        if(!s2.isEmpty()){
	        while(!s2.isEmpty()){
	        	int v = s2.pop();
//	        	System.out.println("last s2 "+v);
				if (v > max) {
					max = v;
				}
	        }
	        lst.add(max);
        }
        return lst;
    }
}
