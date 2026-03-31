package regex;
import java.util.Scanner;
import java.util.regex.Pattern;
public class LicensePlateValidation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the plate number : ");
		String plateNumber = sc.nextLine();
		String regex = "^[A-Z]{2}[0-9]{4}$";
		if (Pattern.matches(regex, plateNumber)) {
            System.out.println("Valid License Plate");
        } else {
            System.out.println("Invalid License Plate");
        }
		sc.close();
	}
}
