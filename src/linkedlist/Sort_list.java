package linkedlist;

import java.util.Scanner;

public class Sort_list {
private static Scanner scan;

public static void main(String[] args) {
	ListNode a  = new ListNode(10);
	ListNode s =a;
	for(int i=0;i<10;i++)
	{
		ListNode b = new ListNode((int)(Math.random()*100+1));
		a.next= b;
		a = a.next;
	}
	ListNode.printList(s, "unsorted");
	Sort_list sl = new Sort_list();
	s=sl.sortList(s);
	ListNode.printList(s, "sorted");
}
public ListNode sortList(ListNode A) {
    
	if(A== null || A.next == null)
		return A;
	int length = 0;
	ListNode h = A;
	while(h !=null){
		length++;
		h = h.next;
	}
	ListNode d = new ListNode(0);
	d.next = A;
	ListNode left,right,tail;
	for(int i=1;i<length;i <<=1){
		h = d.next;
		tail = d;
		while(h != null){
			left = h;
			right = split(left,i);
			h = split(right,i);
			tail = merge(left,right,tail);
		}
	}
	/*ListNode mid =  getMid(A);
	ListNode midNext = mid.next;
	mid.next = null;
	ListNode left = sortList(A);
	ListNode right = sortList(midNext);
	ListNode s = mergeSorted(left,right);*/
	return d.next;
}
private ListNode merge(ListNode l1, ListNode l2, ListNode head) {

	ListNode cur = head;
	while(l1 != null && l2!= null){
		if(l1.val > l2.val){
			cur.next= l2;
			cur = l2;
			l2= l2.next;
		}
		else
		{
			 cur.next = l1;
			 cur = l1;
			 l1 = l1.next;
		}
	}
	cur.next= (l1!=null?l1:l2);
	while(cur.next != null)
		cur = cur.next;
	return cur;
}
private ListNode split(ListNode left, int n) {
	for(int i=1;left != null && i<n;i++){
		left = left.next;
	}
	if(left == null) return null;
	ListNode tmp = left.next;
	left.next = null;
	return tmp;
}
public ListNode getMid(ListNode A){
	if(A == null) 
		return A;
	ListNode fast = A.next;
	ListNode slow = A;
	while(fast !=null){
		fast = fast.next;
		if(fast != null){
			slow = slow.next;
			fast = fast.next;
		}
	}
	return slow;
}
public ListNode mergeSorted(ListNode left,ListNode right){
	ListNode res;
	if(left == null)
		return right;
	if(right == null)
		return left;
	if(left.val <= right.val){
		res = left;
		res.next = mergeSorted(left.next, right);
	}
	else
	{
		res= right;
		res.next = mergeSorted(left, right.next);
	}
	return res;
}
}
