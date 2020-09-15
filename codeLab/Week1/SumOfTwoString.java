/* Sum of two Strings: Given two non-negative integers num1 and 
 * num2 represented as string, return the sum of num1 and num2.
 */

class SumOfTwoString {
	public static void main(String[] args) {
		String num1 = "45332";
		String num2 = "5334765";
		System.out.println("Test result is: " + sumOfTwoString(num1, num2));
	}
	
	public static String sumOfTwoString(String num1, String num2) {
		if (num1.length() == 0) return num2;
		if (num2.length() == 0) return num1;
		StringBuilder sb = new StringBuilder();
		int index1 = num1.length() - 1;
		int index2 = num2.length() - 1;
		int sum = 0;
		int carry = 0;
		while (index1 >= 0 && index2 >= 0) {
			int n1 = num1.charAt(index1) - '0';
			int n2 = num2.charAt(index2) - '0';
			sum = n1 + n2 + carry;
			if (sum >= 10) {
				carry = 1;
			} else {
				carry = 0;
			}
			sb.append(sum % 10);
			index1 -= 1;
			index2 -= 1;
		}
		
		while (index1 >= 0) {
			sum = num1.charAt(index1) - '0' + carry;
			if (sum >= 10) {
				carry = 1;
			} else {
				carry = 0;
			}
			sb.append(sum % 10);
			index1 -= 1;
		}
		
		while (index2 >= 0) {
			sum = num2.charAt(index2) - '0' + carry;
			if (sum >= 10) {
				carry = 1;
			} else {
				carry = 0;
			}
			sb.append(sum % 10);
			index2 -= 1;
		}
		
		if (carry == 1) {
			sb.append(1);
		}
		return sb.reverse().toString();
	}
}