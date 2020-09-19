/* Two Sum Problem: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 */
import java.util.*;
class TwoSum {
	public static void main(String[] args) {
		int[] nums = new int[] {2, 5, 3, 6, 7, 8};
		int target = 5;
		int[] res = twoSum(nums, target);
		System.out.println("First index is: " + res[0]);
		System.out.println("Second index is: " + res[1]);
	}
	
	public static int[] twoSum (int[] nums, int target) {
		int[] res = new int[] {-1, -1};
		if (nums == null || nums.length == 0) return res;
		Map<Integer, Integer> indexToNum = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (indexToNum.containsKey(nums[i])) {
				res[0] = indexToNum.get(nums[i]);
				res[1] = i;
				return res;
			}
			indexToNum.put(target - nums[i], i);
		}
		return res;
	}
}