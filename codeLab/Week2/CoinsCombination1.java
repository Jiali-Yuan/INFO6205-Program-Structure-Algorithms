/*There are 3 buckets of unlimited 5, 10 and 25 cents. 
  If we can pick 5 coins, print all the combinations of  
  of the coins that can be made.*/
import java.util.*;
class Untitled {
	public static void main(String[] args) {
		int[] coins = new int[] {5, 10, 25};
		int num = 5;
		List<List<Integer>> res = coinsCombination (coins, num);
		print(res);
	}
	
	public static List<List<Integer>> coinsCombination (int[] coins, int num) {
		List<List<Integer>> res = new ArrayList<>();
		if (coins == null || coins.length == 0) return res;
		helper(res, new ArrayList<>(), coins, num, 0);
		return res;
	}
	
	public static void helper(List<List<Integer>> res, List<Integer> list, int[] coins, int num, int index) {
		if (list.size() == num) {
			res.add(new ArrayList<>(list));
		}
		
		for (int i = index; i < coins.length; i++) {
			if (list.size() > num) break;
			list.add(coins[i]);
			helper(res, list, coins, num, i);
			list.remove(list.size() - 1);
		}
	}
	
	public static void print (List<List<Integer>> list) {
		for (int i = 0; i < list.size(); i++) {
			List<Integer> current = list.get(i);
			for (int j = 0; j < current.size(); j++) {
				System.out.print(current.get(j) + " ");
			}
			System.out.println();
		}
	}
}