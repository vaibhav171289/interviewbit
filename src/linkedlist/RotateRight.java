package linkedlist;

import java.util.Scanner;

public class RotateRight {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		ListNode a = new ListNode(1);
		ListNode s = a;
		for (int i = 2; i <= 5; i++) {
			ListNode b = new ListNode(i);
			a.next = b;
			a = a.next;

		}
		RotateRight rotate = new RotateRight();
		ListNode res = rotate.rotateRight(s, (int)(Math.random()*10));
		ListNode.printList(res, "result");
	}
	public ListNode rotateRight(ListNode a, int b) {
		ListNode.printList(a, "original");
		System.out.println("index "+b);
		b=0;
	      int c=0;
	      ListNode p=a,q=null,r=null;
	    if(a.next!= null)
	    {
	        
	        while(p!=null)
	        {
	            c++;
	            p=p.next;
	        }
	          p=a;
	            b=b%c;
	        if(b>0 && b<c)
	        {
	          
	             c=c-b-1;
	             
	           //  System.out.println(c);
	            while(c-->0)
	                p=p.next;
	            
	              q=p;
	              p=p.next;
	              if( p.next==null)
	            	  r=p;
	              else 
	              r=p.next;
	              q.next=null;
              while(r!=null && r.next!=null)
                  r=r.next;
              r.next=a;
            	  
              
	        }
	       
	    }
	    return p;
	}
}
