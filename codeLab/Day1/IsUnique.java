/* Is Unique: Implement an algorithm to determine if a string has all unique characters.
 */
import java.util.*;
class IsUnique {
	public static void main(String[] args) {
		String s = "codelab";
		System.out.println("Does each character in the string unique? " + isUnique(s));
	}
	
	public static boolean isUnique (String s) {
		if (s == null || s.length() == 0) return false;
		
		//If case censitive, add one below more line code.
		// s = s.toLowerCase();
		
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
			if (map.get(c) > 1) {
				return false;
			}
		}
		return true;
	}
}