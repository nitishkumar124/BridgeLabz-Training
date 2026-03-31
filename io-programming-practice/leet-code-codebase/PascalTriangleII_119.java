package week5;

import java.util.*;

public class PascalTriangleII_119 {

	public static void main(String[] args) {
		int rowIndex = 3;
		System.out.println(getRow(rowIndex));
	}

	public static List<Integer> getRow(int rowIndex) {
		List<List<Integer>> rows = new ArrayList<>();
		rows.add(List.of(1));
		for (int i = 1; i <= rowIndex; i++) {
			List<Integer> temp = new ArrayList<>();
			List<Integer> curr = rows.get(i - 1);
			temp.add(1);
			for (int j = 0; j < i - 1; j++) {
				temp.add(curr.get(j) + curr.get(j + 1));
			}
			temp.add(1);
			rows.add(temp);
		}
		return rows.get(rowIndex);
	}
}
