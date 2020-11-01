public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	if (nums1 == null || nums1.length == 0) return nums1;
	Map<Integer, Integer> map = new HashMap<>();
	Stack<Integer> s = new Stack<>();
	for (int i = nums2.length - 1; i >= 0; i--) {
		if (s.isEmpty()) {
			map.put(nums2[i], -1);
		} else {
			if (s.peek() > nums2[i]) {
				map.put(nums2[i], s.peek());
			} else {
				while (!s.isEmpty() && s.peek() < nums2[i]) {
					s.pop();
				}
				if (s.isEmpty()) {
					map.put(nums2[i], -1);
				} else {
					map.put(nums2[i], s.peek());
				}
			}
		}
		s.push(nums2[i]);
	}
	int[] res = new int[nums1.length];
	for (int i = 0; i < nums1.length; i++) {
		res[i] = map.get(nums1[i]);
	}
	return res;
}