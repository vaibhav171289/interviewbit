package stack_queue;

import java.util.ArrayList;
import java.util.Scanner;

public class Largest_Rectangle_In_Histogram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
			int n= sc.nextInt();
			ArrayList<Integer> a= new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				a.add(sc.nextInt());
			}
			System.out.println(new Largest_Rectangle_In_Histogram().largestRectangleArea(a));
		}
				
	}
	public int largestRectangleArea(ArrayList<Integer> a)
	{
	    Stack<Integer>  st= new Stack<Integer> ();
	    int max=0,i=0,top=-1,area=0;
	    for(i=0;i<a.size();)
	    {
	        if(st.isEmpty() || a.get(i)>a.get(st.peek()))
            {
                st.push(i);
                i++;
            }
            else
            {
            	while(!st.isEmpty() && a.get(i)<a.get(st.peek())){
	                top= st.pop();
	                int w=0;
	                if(st.isEmpty())
	                    w=i;
	                else
	                	w=i-st.peek()-1;
	                area = a.get(top)*w;
	                if(area > max)
	                    max=area;
            	}
            	st.push(i++);
            }
	    }
	    while(!st.isEmpty())
	    {
	         top = st.pop();
//	         System.out.println(top);
	         int w=0;
             if(st.isEmpty())
                w=i;
             else
            	w=i-st.peek()-1;
             area = w*a.get(top);
            if(area > max)
	          max=area;
	    }
	    return max;
	}
}
