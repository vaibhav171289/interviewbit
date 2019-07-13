package linkedlist;

import java.util.Scanner;

public class DetectCycle {
	static Scanner scan=new Scanner(System.in);
public static void main(String[] args) {
	
		ListNode a = new ListNode(1);
		ListNode s = a;
		for(int i=2;i<=12;i++)
		{
			ListNode b= new ListNode(i);
				a.next=b;
				a=a.next;
				
		}
//		a.next=s;
		DetectCycle dc= new DetectCycle();
		ListNode res = dc.detectCycle(s);
		ListNode.printList(res, "result");
	}
	public ListNode detectCycle(ListNode a) {
	    ListNode p=a,q=a;
	    while(p!=null  && q!=null && q.next !=null)
	    {
	       // System.out.println(p.val +"  "+q.val);
	        
	        p=p.next;
	        q=q.next.next;
	        if(p==q)
	            return p;
	            
	    }
	    return null;
	}
}
