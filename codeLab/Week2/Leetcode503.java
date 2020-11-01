public int[] nextGreaterElements(int[] nums) {
	if (nums == null || nums.length == 0) return nums;
	int[] temp = new int[nums.length * 2];
	int n = temp.length;
	int m = nums.length;
	for (int i = 0; i < n; i++) {
		temp[i] = nums[i % m];
	}
	
	int[] nextGreater = new int[n];
	Stack<Integer> s = new Stack<>();
	for (int i = n - 1; i >= 0; i--) {
		if (s.isEmpty()) {
			nextGreater[i] = -1;
		} else {
			if (s.peek() > temp[i]) {
				nextGreater[i] = s.peek();
			} else {
				while (!s.isEmpty() && s.peek() <= temp[i]) {
					s.pop();
				}
				if (s.isEmpty()) {
					nextGreater[i] = -1;
				} else {
					nextGreater[i] = s.peek();
				}
			}
		}
		s.push(temp[i]);
	}
	
	int[] res = new int[m];
	for (int i = 0; i < m; i++) {
		res[i] = nextGreater[i];
	}
	return res;
}