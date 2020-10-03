public ListNode removeElements(ListNode head, int val) {
	if (head == null) return head;
	ListNode dummy = new ListNode();
	dummy.next = head;
	ListNode cur = dummy;
	ListNode temp = head;
	while (temp != null) {
		if (temp.val != val) {
			cur.next = temp;
			cur = cur.next;
		}
		temp = temp.next;
	}
	cur.next = null;
	return dummy.next;
}