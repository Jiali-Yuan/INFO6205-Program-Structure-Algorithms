	public ListNode[] splitListToParts(ListNode root, int k) {
		ListNode temp = root;
		int num = 0;
		while (temp != null) {
			num += 1;
			temp = temp.next;
		}
		
		int size = num / k;
		int remain = num % k;
		
		ListNode[] res = new ListNode[k];
		temp = root;
		ListNode head = root;
		for (int i = 0; i < k && temp != null; i++) {
			for (int j = 1; j < size + (remain > 0 ? 1 : 0); j++) {
				temp = temp.next;
			}
			ListNode tail = temp.next;
			temp.next = null;
			res[i] = head;
			head = tail;
			temp = head;
			remain -= 1;
		}
		return res;
	}