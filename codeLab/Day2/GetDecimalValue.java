/* Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

 */

class GetDecimalValue {
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		add(node, 0);
		add(node, 0);
		add(node, 0);
		add(node, 0);
		System.out.println("test: " + convert(node));
	}
	
	public static int convert (ListNode node) {
		StringBuilder sb = new StringBuilder();
		while (node != null) {
			sb.append(node.val);
			node = node.next;
		}
		return getDecimal(sb.toString());
	}
	
	public static int getDecimal (String s) {
		char[] c = s.toCharArray();
		int n = 0;
		int res = 0;
		for (int i = c.length - 1; i >= 0; i--) {
			res += (c[i] - '0') * Math.pow(2, n);
			n += 1;
		}
		return res;
	}
	
	public static void add(ListNode node, int val){
		ListNode cur = node;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = new ListNode(val);
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
