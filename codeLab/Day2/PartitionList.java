/* Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 */

class Partition {
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		add(node, 4);
		add(node, 3);
		add(node, 2);
		add(node, 5);
		add(node, 2);
		int val = 3;
		ListNode test = partition(node, 3);
		printList(test);
	}
	
	public static ListNode partition (ListNode node, int val) {
		if (node == null || node.next == null) return node;
		ListNode smallHead = new ListNode(0);
		ListNode small = smallHead;
		ListNode largeHead = new ListNode(0);
		ListNode large = largeHead;
		while (node != null) {
			if (node.val < val) {
				small.next = node;
				small = small.next;
			} else {
				large.next = node;
				large = large.next;
			}
			node = node.next;
		}
		large.next = null;
		small.next = largeHead.next;
		return smallHead.next;
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
