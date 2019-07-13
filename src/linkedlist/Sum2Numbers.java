package linkedlist;

public class Sum2Numbers {
public static void main(String[] args) {
	ListNode p,q;
	ListNode a = new ListNode(9);
	p=a;
	a.next = new ListNode(9);
	a=a.next;
	a.next = new ListNode(1);
	ListNode b= new ListNode(1);
	Sum2Numbers sumNum = new Sum2Numbers();
	ListNode res = sumNum.addTwoNumbers(p, b);
	ListNode.printList(res, "result ");
}
	public ListNode addTwoNumbers(ListNode a, ListNode b) {
		ListNode.printList(a, "a");
		ListNode.printList(b, "b");
	    ListNode p=null;
	    int borrow=0;
	    ListNode q=null;
	    while(a!=null || b!=null)
	    {
	    	int sum=0;
	    	if(a!=null && b!=null)
	         sum = a.val+b.val+borrow;
	    	else if(a!=null && b ==null)
	    		sum = a.val+borrow;
	    	else 
	    		sum = b.val+borrow;
	        borrow = sum/10;
	        int num = sum%10;
	        System.out.println("sum = "+sum);
	        if(p==null)
	            {
	        		p = new ListNode(num);
	        		q=p;
	            }
	        else
	        {
	        	p.next=new ListNode(num);
	        	p=p.next;
	        }
	        
	        if(a!=null)
	        a=a.next;
	        if(b!=null)
	        b=b.next;
	    }
	    if(a==null && b==null && borrow==1)
	    {
	    	p.next=new ListNode(1);
	    	
	    }
	    
	    
	    
	return q;
	}
}

