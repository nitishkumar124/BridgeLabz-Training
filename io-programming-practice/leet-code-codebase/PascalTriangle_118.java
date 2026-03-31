package week5;
import java.util.*;
public class PascalTriangle_118 {

	public static void main(String[] args) {
		int numRows = 10;	
		System.out.println(generate(numRows));
	}
	
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> curr = result.get(i - 1);
            temp.add(1);

            for (int j = 0; j < i - 1; j++) {                
                temp.add(curr.get(j) + curr.get(j + 1));
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }
}

