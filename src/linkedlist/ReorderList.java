package linkedlist;

import java.util.Scanner;

public class ReorderList {
	static Scanner scan=new Scanner(System.in);
public static void main(String[] args) {
		
		ListNode a = new ListNode(1);
		ListNode s = a;
		for(int i=2;i<=2;i++)
		{
			ListNode b= new ListNode(i);
				a.next=b;
				a=a.next;
				
		}
		ReorderList ro  = new ReorderList();
		ListNode res = ro.reorderList(s);
		ListNode.printList(res, "result");
	}
	public ListNode reorderList(ListNode a) {
		ListNode p=a;
		if(p!=null)
		{
		
		ListNode q=p;
		while(p!=null)
		{
			q=q.next;
			if(p.next!=null)
			p=p.next.next;
			else
				p=p.next;
			
		}
		p=a;
//		ListNode.printList(q, "q");
		ListNode r=reverseList(q);
//		ListNode.printList(r, "r");
//		ListNode.printList(p, "before p");
		if(r==null)
			return p;
			q=null;
		while(p!=null && r!=null )
		{
//			ListNode.printList(a, "original ");
			
//			ListNode.printList(p, "temp p");
//			ListNode.printList(r, "temp r");
			ListNode t=p.next;
//			System.out.println("t "+t.val);
			p.next=r;
//			System.out.println("p.next.val "+p.next.val);
			ListNode t2=r.next;
//			System.out.println("t2 "+t2.val);
//			System.out.println("r "+r.val);
			r.next=t;
//			System.out.println("r.next,val "+r.next.val);
			r=t2;
			
			if(p.next!=null)
			p=p.next.next;
			else
				p=p.next;
		}
		if(r!=null)
		r.next=null;
		else
		if(p!=null)
			p.next=null;
		p=null;
		r=null;
//		ListNode.printList(p, "p");
//		scan.nextLine();
//		ListNode.printList(q, "q");
//		scan.nextLine();
//		ListNode.printList(a, "final ");
		return a;
		}
		
		return null;
	}
	public ListNode reverseList(ListNode a) {
		ListNode p = a;
		ListNode q = null, r = null;
		if (p != null && p.next != null) {
			while (p != null) {
				q = p;
				p = p.next;
				q.next = r;
				r = q;

			}
			return q;
		}
		return p;
	}
}
