public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	Map<Integer, Integer> map = new HashMap<>();
	int[] answer = new int[nums1.length];
	if (nums2.length == 0 || nums1.length == 0) return answer;
	if (nums2.length == 1) {
		answer[0] = -1;
		return answer;
	}

	int i = 0;
	int j = 1;
	int limit = nums2.length;
	while (i < limit) {
		if (j < limit) {
			if (nums2[i] < nums2[j]) {
				map.put(nums2[i], nums2[j]);
				i++;
				j=i;
			}
			j++;
		}
		else{
			map.put(nums2[i], -1);
			i++;
			j=i+1;
		}
	}
	for (int k = 0; k < nums1.length; k++) {
		answer[k] = map.get(nums1[k]);
	}
	return answer;
	}
}