public ListNode swapPairs(ListNode head) {
	if (head == null || head.next == null) return head;
	ListNode dummy = new ListNode();
	dummy.next = head;
	ListNode cur = dummy;
	while (cur.next != null && cur.next.next != null) {
		ListNode first = cur.next;
		ListNode second = cur.next.next;
		cur.next = second;
		first.next = second.next;
		second.next = first;
		cur = first;
	}
	return dummy.next;
}