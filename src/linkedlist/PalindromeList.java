package linkedlist;

public class PalindromeList {
	public static void main(String[] args) {

		ListNode a = new ListNode(1);
		ListNode s = a;
		for (int i = 2; i <= 1; i++) {
			ListNode b = new ListNode(i);
			a.next = b;
			a = a.next;

		}
		for (int i = 4; i >= 3; i--) {
			ListNode b = new ListNode(i);
			a.next = b;
			a = a.next;

		}
		PalindromeList pl= new PalindromeList();
		int res = pl.lPalin(s);
		System.out.println(res);
	}

	  public int lPalin(ListNode A) {
		  ListNode.printList(A, "original");
		  ListNode p=A;
		  int count=0;
		  while(p!=null)
		  {
			  count++;
			  p=p.next;
		  }
		  int mid =count/2;
		  p=A;
		  while(mid-- >0)
		  {
			  p=p.next;
		  }
		  ListNode q=p,r=null;
		  
		  if (p != null && p.next != null) {
				while (p != null) {
					q = p;
					p = p.next;
					q.next = r;
					r = q;

				}
			}
		  
		  mid=count/2;
		  int i=0;
		  p=A;
		  while(i<mid)
		  {
			  if(p.val!=q.val)
				  return 0;
			  
			  p=p.next;
			  q=q.next;
			  i++;
		  }
		  return 1;
	    }
}
