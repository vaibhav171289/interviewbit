package linkedlist;

import java.util.HashMap;
import java.util.Scanner;

public class RemoveDuplicates {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		ListNode a = new ListNode(1);
		ListNode s = a;
		a.next=new ListNode(2); a=a.next;
		a.next=new ListNode(3);a=a.next;
		a.next=new ListNode(4);a=a.next;
		
		int j = 6;
		for (int i = 6; i <= 12; i++) {
			ListNode b = new ListNode(j);
			a.next = b;
			a = a.next;
			if (i % 3 == 0)
				j++;

		}
		ListNode.printList(s, "original");
		RemoveDuplicates dup = new RemoveDuplicates();
		ListNode res = dup.deleteDuplicatesII(s);
		ListNode.printList(res, "result");
	}

	public ListNode deleteDuplicates(ListNode a) {

		ListNode p = a, q = null;
		while (p!=null && p.next != null) {
			q = p;
			while (p.next != null && p.val == p.next.val) {
				p = p.next;
			}
			if (p.next == null)
				q.next=null;
			else
			q.next = p.next;
			p = p.next;

		}
		return a;
	}
	public ListNode deleteDuplicatesII(ListNode a) {

		ListNode p = a, q = null;
		HashMap<Integer, Integer> map = new HashMap<>();
		while (p!=null) {
			if(!map.containsKey(p.val))
			{
				map.put(p.val, 1);
			}
			else
			{
				map.put(p.val, map.get(p.val)+1);
			}
			p=p.next;
		}
		p=a;
		ListNode r=q;
		while(p!=null)
		{
			
			if(map.get(p.val)==1)
			{
				if(q==null)
					{
						q=p;
						r=q;
					}
				else
					{
						q.next=p;
						q=q.next;
					}
				
			}
			p=p.next;
		}
		q.next=null;
		return r;
	}
}
