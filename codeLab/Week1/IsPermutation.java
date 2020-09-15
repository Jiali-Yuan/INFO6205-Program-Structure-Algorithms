/* Check Permutation: Given two strings, write a method to decide if one is a permutation of the other
 */
import java.util.*;
class IsPermutation {
	public static void main(String[] args) {
		String s1 = "codelab";
		String s2 = "labcode";
		System.out.println("Is permutation? " + isPermutation(s1, s2));
	}
	
	public static boolean isPermutation (String s1, String s2) {
		if (s1 == null || s2 == null) return false;
		if (s1.length() != s2.length()) return false;
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		buildMap(s1, map1);
		buildMap(s2, map2);
		for (char c : s1.toCharArray()) {
			if (map1.get(c) != map2.get(c)) {
				return false;
			}
		}
		return true;	
	}
	
	public static void buildMap (String s, Map<Character, Integer> map) {
		if (s == null || s.length() == 0) return;
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
	}
}