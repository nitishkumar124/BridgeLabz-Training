package week9;

public class MinCostClimbingStairs_746 {
	public int minCostClimbingStairs(int[] cost) {
		int prev2 = cost[0];
		int prev1 = cost[1];

		for (int i = 2; i < cost.length; i++) {
			int curr = cost[i] + Math.min(prev1, prev2);

			prev2 = prev1;
			prev1 = curr;
		}

		return Math.min(prev1, prev2);
	}

	public static void main(String[] args) {
		MinCostClimbingStairs_746 solution = new MinCostClimbingStairs_746();
		int[] cost = { 10, 15, 20 };
		System.out.println(solution.minCostClimbingStairs(cost));
	}
}
