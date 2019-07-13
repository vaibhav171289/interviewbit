package linkedlist;

public class ListNode {
	public int val;
	public ListNode next;
	ListNode(){
		
	}
	ListNode(int x) {
		val = x;
		next = null;
	}
   
	public static void printList(ListNode a, String str) {
		if (a != null) {
			if (str.length() != 0)
				System.out.println("printing " + str + " list");
			while (a.next != null) {
				System.out.print(a.val + " --> ");
				a = a.next;
			}
			System.out.println(a.val);

			System.out.println("-----------------");
		}
		else if (str.length() != 0)
			System.out.println(str +" list is null");
	}
}
