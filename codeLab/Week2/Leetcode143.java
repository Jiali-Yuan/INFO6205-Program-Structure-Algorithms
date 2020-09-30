	public void reorderList(ListNode head) {
		if (head == null || head.next == null) return;
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode second = slow.next;
		slow.next = null;
		ListNode secondHead = reverse(second);
		ListNode firstHead = head;
		ListNode cur = head;
		while (secondHead != null) {
			ListNode firstNext = firstHead.next;
			ListNode secondNext = secondHead.next;
			firstHead.next = secondHead;
			secondHead.next = firstNext;
			firstHead = firstNext;
			secondHead = secondNext;
		}
	}
	
	private ListNode reverse (ListNode node) {
		if (node == null || node.next == null) {
			return node;
		}
		ListNode pre = null;
		while (node != null) {
			ListNode nextNode = node.next;
			node.next = pre;
			pre = node;
			node = nextNode;
		}
		return pre;
	}