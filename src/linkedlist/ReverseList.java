package linkedlist;

public class ReverseList {
	public static void main(String[] args) {

		ListNode a = new ListNode(1);
		ListNode s = a;
		for (int i = 2; i <= 1; i++) {
			ListNode b = new ListNode(i);
			a.next = b;
			a = a.next;

		}
		ReverseList rl = new ReverseList();
		ListNode r = rl.reverseList(s);
		ListNode.printList(r, "r");
	}

	public ListNode reverseList(ListNode a) {
		ListNode p = a;
		ListNode q = null, r = null;
		if (p != null && p.next != null) {
			while (p != null) {
				q = p;
				p = p.next;
				q.next = r;
				r = q;

			}
			return q;
		}
		return p;
	}
}
