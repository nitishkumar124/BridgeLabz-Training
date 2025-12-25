package practice_problems;
import java.util.*;
public class AverageOfThreeNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("num1 : ");
		double num1 = sc.nextDouble();
		System.out.print("num2 : ");
		double num2 = sc.nextDouble();
		System.out.print("num3 : ");
		double num3 = sc.nextDouble();

		double avg = (num1 + num2 + num3) / 3;
		System.out.println("average : " + avg);

	}

}
