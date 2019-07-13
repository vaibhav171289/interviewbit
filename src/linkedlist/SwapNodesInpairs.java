package linkedlist;

import java.util.Scanner;

public class SwapNodesInpairs {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		ListNode a = new ListNode(1);
		ListNode s = a;
		for (int i = 2; i <= 12; i++) {
			ListNode b = new ListNode(i);
			a.next = b;
			a = a.next;

		}
		SwapNodesInpairs swap = new SwapNodesInpairs();
		ListNode res = swap.swapPairs(s);
		ListNode.printList(res, "result");
	}
	public ListNode swapPairs(ListNode a) {
		ListNode p =a;
		ListNode q=null,r=null,l=null;
		if(p!=null && p.next!=null)
			l=p.next;
		else
			l=p;
		while(p!=null && p.next!=null)
		{
			q=p.next;
			p.next=q.next;
			q.next=p;
			if(r==null)
			r=p;
			else
				{
					r.next=q;
					r=p;
				}
			
			p=p.next;
			
		}
		return l;
	}
}
