	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode dummy = new ListNode();
		ListNode realHead = dummy;
		ListNode cur = head;
		ListNode pre = dummy;
		while (cur != null) {
			if ((pre == dummy || pre.val != cur.val) && (cur.next == null || cur.val != cur.next.val)) {
				realHead.next = cur;
				realHead = realHead.next;
			}
			pre = cur;
			cur = cur.next;
			
		}
		realHead.next = null;
		return dummy.next;
	}