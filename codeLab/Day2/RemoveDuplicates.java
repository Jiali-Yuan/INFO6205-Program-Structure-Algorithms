/* Given a linked list, remove the n-th node from the end of list and return its head.

 */

class RemoveDuplicates {
	public static void main(String[] args) {
		ListNode node = new ListNode(0);
		add(node, 1);
		add(node, 1);
		add(node, 2);
		add(node, 3);
		add(node, 4);
		ListNode test = removeDuplicate(node);
		printList(test);
	}
	
	public static ListNode removeDuplicates(ListNode node) {
		if (node == null || node.next == null) return node;
		ListNode dummy = new ListNode(0);
		dummy.next = node;
		ListNode cur = dummy.next;
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}
	
	public static void add(ListNode node, int val){
		ListNode cur = node;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = new ListNode(val);
	}
		
	public static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.println("null");
	}
	
}

class ListNode {
	ListNode next;
	int val;
	public ListNode(int val) {
		this.val = val;
	}
	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
