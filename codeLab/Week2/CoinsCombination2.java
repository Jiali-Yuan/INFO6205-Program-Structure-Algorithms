/*I have following coins 1,1,1,1,1,5,5,5,10,10,10,10, 25,25 
  Can I make a total of 73 cents. if yes how many combinations 
  can I make print them out. Hint This is baqsically generate 
  all sub sets (Binary sequence*/
import java.util.*;
class Untitled {
	public static void main(String[] args) {
		int[] coins = new int[] {1,1,1,1,1,5,5,5,10,10,10,10, 25,25};
		int target = 73;
		System.out.println("The coins can make total of 73 cents? -> " + coinsCombination1(coins, target));
		
		System.out.println("If yes, how many combinations?");
		List<List<Integer>> list = coinsCombination2(coins, target);
		print(list);
	}
	
	public static boolean coinsCombination1 (int[] coins, int target) {
		boolean[] possible = new boolean[1];
 		helper1(coins, target, 0, 0, possible);
		return possible[0];
	}
	
	public static void helper1 (int[] coins, int target, int index, int sum, boolean[] possible) {
		if (sum == target) {
			possible[0] = true;
			return;
		}
		for (int i = index; i < coins.length; i++) {
			helper1(coins, target, i + 1, sum + coins[i], possible);
		}
	}
	
	public static List<List<Integer>> coinsCombination2 (int[] coins, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(coins);
		boolean[] visited = new boolean[coins.length];
		helper2(res, new ArrayList<>(), coins, target, 0, 0, visited);
		return res;
	}
	
	public static void helper2 (List<List<Integer>> res, List<Integer> list, int[] coins, int target, int sum, int index, boolean[] visited) {
		if (sum == target) {
			res.add(new ArrayList<>(list));
		}
		for (int i = index; i < coins.length; i++) {
			if (visited[i]) continue;
			if (sum > target) break;
			list.add(coins[i]);
			visited[i] = true;
			helper2(res, list, coins, target, sum + coins[i], i + 1, visited);
			list.remove(list.size() - 1);
			visited[i] = false;
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