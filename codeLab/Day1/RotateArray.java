/* Rotate and array: Given an array, rotate the array to the right by k steps, where k is non-negative.
 */

class RotateArray {
	public static void main(String[] args) {
		int[] array = new int[] {1, 2, 3, 4, 5, 6, 7};
		int k = 13;
		int[] test = rotateArray(array, k);
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i]);
		}
	}
	
	public static int[] rotateArray (int[] array, int k) {
		if (array == null || array.length == 0) return array;
		int n = array.length;
		if (k % n == 0) return array;
		rotate(array, 0, n - 1);
		rotate(array, 0, k % n - 1);
		rotate(array, k % n, n - 1);
		return array;
	}
	
	public static void rotate(int[] array, int left, int right) {
		if (left >= right) return;
		while (left < right) {
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left += 1;
			right -= 1; 
		}
	} 
}