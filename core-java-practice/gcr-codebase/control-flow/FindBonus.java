package level1;
import java.util.*;
public class FindBonus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Salary: ");
		double salary = sc.nextInt();
		System.out.print("Enter Year of Service: ");
		int year = sc.nextInt();
		if (year > 5) {
			double bonus = salary * 0.05;
			System.out.println("You recieved " + bonus + " as bonus.");
		} else {
			System.out.println("Oops! you need to complete 5 years of service to recieve bonus.");
		}
		sc.close();
	}
}

