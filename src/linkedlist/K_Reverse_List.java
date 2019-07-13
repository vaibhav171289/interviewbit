package linkedlist;

import java.util.Scanner;

public class K_Reverse_List {
	static Scanner scan=new Scanner(System.in);
public static void main(String[] args) {
	
		ListNode a = new ListNode(1);
		ListNode s = a;
		for(int i=2;i<=11;i++)
		{
			ListNode b= new ListNode(i);
				a.next=b;
				a=a.next;
				
		}
		K_Reverse_List rev = new K_Reverse_List();
		ListNode res = rev.reverseList(s, scan.nextInt());
		ListNode.printList(res, "result");
	}
	  public ListNode reverseList(ListNode A, int B) {
		  ListNode p = A;
			int c=0;
			ListNode q = null, r = null,s=null,t=null;
			while (p != null && p.next != null) {
//				System.out.println("p val "+p.val+"  p next "+p.next.val);
				q=null;r=null;
				while (p != null && c!=B) {
					
					q = p;
					p = p.next;
					q.next = r;
					r = q;
					c++;
					
					
				}
				if(s==null)
					{
						s=q;
						
						A.next=p;
						t=p;
//						System.out.println(A.val+" --- "+p.val+" -- "+p.next.val);
//						ListNode.printList(s, "s");
					}
				else
				{
//					ListNode.printList(s, "s");
//					ListNode.printList(q, "q");
//					System.out.println("A val "+A.val);
					A.next=q;
					t.next=p;
					A=t;
					t=p;
					
					
				}
				
				c=0;
//				scan.nextLine();
			}
			return s;
		}
			
}
