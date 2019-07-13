package linkedlist;

import java.util.Scanner;

public class InsertionSortList {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		ListNode a = new ListNode(1);
		ListNode s = a;
		for (int i = 2; i <= 5; i++) {
			ListNode b = new ListNode((int) (Math.random() * 10));
			a.next = b;
			a = a.next;

		}
		ListNode.printList(s, "original");
		InsertionSortList ISL = new InsertionSortList();

		ListNode res =ISL.insertionSortList(s);
		ListNode.printList(res, "res");
	}
	public ListNode insertionSortList(ListNode a) {
		
		ListNode p=a;
		if(p==null || p.next == null)
			return a;
		else
		{
			ListNode q=null,t=null;
			
			while(p!=null)
			{
				if(t==null)
					t=new ListNode(p.val);
				else 
				{
					ListNode r=null;
					q=t;
//					System.out.println(q.val+"  -->  "+p.val);
					while(q!=null && q.val<=p.val)
					{
//						System.out.println(q.val+"  -->  "+p.val);
						
						r=q;
						q=q.next;
						
					}
					if(r!=null)
					{
//						System.out.println("r "+r.val);
						r.next=new ListNode(p.val);
						r.next.next=q;
					}
					else
						{
							r=new ListNode(p.val);
							r.next=q;
							t=r;
						}
					
					
				}
				p=p.next;
//				ListNode.printList(t,"t");
			}
			return t;
		}
		
		
	}
}
