	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) return head;
		Stack<ListNode> s = new Stack<>();
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode temp = dummy;
		ListNode cur = dummy.next;
		while (cur != null) {
			for (int i = 0; i < k && cur != null; i++) {
				s.push(cur);
				cur = cur.next;
			}
			if (s.size() != k) return dummy.next;
			while (!s.isEmpty()) {
				temp.next = s.pop();
				temp = temp.next;
			}
			temp.next = cur;
		}
		return dummy.next;
	}