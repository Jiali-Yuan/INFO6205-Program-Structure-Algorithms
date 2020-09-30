class DeleteNodes {
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		add(node, 2);
		add(node, 3);
		add(node, 4);
		add(node, 5);
		add(node, 6);
		add(node, 7);
		add(node, 8);
		add(node, 9);
		add(node, 10);
		add(node, 11);
		ListNode test = deleteNodes(node, 3, 1);
		printList(test);
	}


	public static ListNode deleteNodes (ListNode head, int m, int n) {
		if (head == null) return null;
		ListNode dummy = head;
		ListNode cur = dummy;
		int i = 1;
		int j = 0;
		while (cur != null) {
			while (i < m) {
				dummy = dummy.next;
				i += 1;
			}
			cur = dummy;
			while (cur != null && j <= n) {
				cur = cur.next;
				j += 1;
			}
			dummy.next = cur;
			dummy = dummy.next;
			cur = dummy;
			i = 1;
			j = 0;
		}
		return head;
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
