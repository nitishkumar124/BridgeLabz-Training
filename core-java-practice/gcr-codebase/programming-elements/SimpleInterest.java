package practice_problems;
import java.util.*;
public class SimpleInterest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("what's the principal amount : ");
		double principal = sc.nextDouble();
		System.out.print("what's the rate of interest : ");
		double rate = sc.nextDouble();
		System.out.print("what's the time of investment : ");
		int time = sc.nextInt();
		double simple_interest = (principal * rate * time) / 100; 
		System.out.println("Simple Interest : " + simple_interest);

	}

}
