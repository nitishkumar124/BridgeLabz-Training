package practice_problems;
import java.util.*;
public class ConvertKilometersToMiles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("distance in km : ");
		double km = sc.nextDouble();

		double miles = km * 0.621371;
		System.out.println("miles : " + miles);

	}

}
