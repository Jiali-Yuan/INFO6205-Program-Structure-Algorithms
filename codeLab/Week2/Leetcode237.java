	public void deleteNode(ListNode node) {
		if (node == null) return;
		int value = node.next.val;
		node.next = node.next.next;
		node.val = value;
	}