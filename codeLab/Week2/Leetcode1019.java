	public int[] nextLargerNodes(ListNode head) {
		if (head == null) return new int[]{};
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		int[] res = new int[list.size()];
		Stack<Integer> s = new Stack<>();
		for (int i = list.size() - 1; i >= 0; i--) {
			if (s.isEmpty()) {
				res[i] = 0;
			} else {
				while (!s.isEmpty() && s.peek() <= list.get(i)) {
					s.pop();
				}
				if (!s.isEmpty()) {
					res[i] = s.peek();
				} else {
					res[i] = 0;
				}
			}
			s.push(list.get(i));
		}
		return res;
	}