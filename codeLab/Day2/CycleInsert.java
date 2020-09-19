/* Given a node from a Circular Linked List which is sorted in ascending order, write a function to insert a value insertVal into the list such that it remains a sorted circular list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the circular list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the circular list should remain sorted.

If the list is empty (i.e., given node is null), you should create a new single circular list and return the reference to that single node. Otherwise, you should return the original given node.

 */

class CycleInsert {
	public static void main(String[] args) {
		ListNode node = new ListNode(4);
		add(node, 5);
		add(node, 6);
		add(node, 1);
		add(node, 3);
		ListNode test = cycleInsert(node, 2);
		printList(test);
	}
	
	public static ListNode cycleInsert (ListNode node, int value) {
		if (node == null) {
			ListNode cur = new ListNode(value);
			cur.next = cur;
			return cur;
		}
		
		ListNode dummy = node;
		while (dummy != null) {
			if (dummy.val < value && dummy.next.val >= value) {
				ListNode nextNode = dummy.next;
				dummy.next = new ListNode(value);
				dummy = dummy.next;
				dummy.next = nextNode;
				break;
			}
			dummy = dummy.next;
		}
		return node;
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
