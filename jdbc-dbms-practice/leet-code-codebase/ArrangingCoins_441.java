package week9;
public class ArrangingCoins_441 {
	public int arragneCoins(int n) {
		int row = 0;
		while(n >= row + 1) {
			row++;
			n -= row;
		}
		return row;
	}
	public static void main(String[] args) {
		ArrangingCoins_441 solution = new ArrangingCoins_441();
		int n = 5;
		System.out.println(solution.arragneCoins(n));
	}
}
