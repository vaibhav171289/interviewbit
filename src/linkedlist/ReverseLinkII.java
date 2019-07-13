package linkedlist;

public class ReverseLinkII {
	public static void main(String[] args) {
		
		ListNode a = new ListNode(1);
		ListNode s = a;
		for(int i=2;i<=1;i++)
		{
			ListNode b= new ListNode(i);
				a.next=b;
				a=a.next;
				
		}
		ReverseLinkII rl = new ReverseLinkII();
		ListNode r = rl.reverseBetween(s, 1, 1);
		ListNode.printList(r, "final");
		
	}
	public ListNode reverseBetween(ListNode a, int m, int n) {
	    ListNode p = a;
	    ListNode q=null,r=null,x=null,y=null;
	    int c=1;
	   
	    while(m>c && p!=null)
	    {
	    	c++;
    		q=p;	    	
	        p=p.next;
	    }
	    x=p;
	    
	    while(c<=n && x!=null)
	    {
	    	c++;
	    	y=x;
	    	x=x.next;
	    }
	    /*ListNode.printList(p, "p");
	    ListNode.printList(q, "q");
	    ListNode.printList(x, "x");
	    ListNode.printList(y, "y");*/
	    ListNode c_ptr=p,pre_ptr=q,pre_back_ptr=null;
	    while(c_ptr!=x)
	    {
	    	pre_ptr=c_ptr;
	    	c_ptr=c_ptr.next;
	    	pre_ptr.next=pre_back_ptr;
	    	pre_back_ptr=pre_ptr;
	    }
	    if(q!=null)
	    q.next=pre_ptr;
	    p.next=x;
	    /*  System.out.println("after ");
	    ListNode.printList(p, "p");
	    ListNode.printList(q, "q");
	    ListNode.printList(x, "x");
	    ListNode.printList(y, "y");*/
	    if(q==null)
	    	return y;
	    return a;
	}
	
}
