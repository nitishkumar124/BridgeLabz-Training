package week9;
import java.util.*;
public class NumberComplement_476 {
	public int findComplement(int num) {
		String b = Integer.toBinaryString(num);
		StringBuilder complement = new StringBuilder();
		
		for (char c : b.toCharArray()) {
			complement.append(c == '0' ? '1' : '0');
		}
		return Integer.parseInt(complement.toString(), 2);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int num = sc.nextInt();
		NumberComplement_476 solution = new NumberComplement_476();
		int result = solution.findComplement(num);
		System.out.println("The complement of the number is: " + result);
		sc.close();
	}
}
