package linkedlist;

import java.util.Scanner;


public class PartitionKey {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		ListNode a = new ListNode(1);
		ListNode s = a;
		for (int i = 2; i <= 10; i++) {
			ListNode b = new ListNode((int) (Math.random() * 10));
			a.next = b;
			a = a.next;

		}
		ListNode.printList(s, "original");
		PartitionKey pk = new PartitionKey();

		ListNode res = pk.partition(s, scan.nextInt());
		ListNode.printList(res, "res");
	}

	public ListNode partition(ListNode a, int b) {
		 if(a == null) return null;
		 
	        ListNode fakeHead1 = new ListNode(0);
	        ListNode fakeHead2 = new ListNode(0);
	        fakeHead1.next = a;
	 
	        ListNode p = a;
	        ListNode prev = fakeHead1;
	        ListNode p2 = fakeHead2;
	 
	        while(p != null){
	            if(p.val < b){
	                p = p.next;
	                prev = prev.next;
	            }else{
	 
	                p2.next = p;
	                prev.next = p.next;
	 
	                p = prev.next;
	                p2 = p2.next;
	            } 
	        }
	 
	        // close the list
	        p2.next = null;
	 
	        prev.next = fakeHead2.next;
	 
	        return fakeHead1.next;
	}
}
