package practice_problems;
import java.util.*;
public class PerimeterOfRectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("what's the length : ");
		double length = sc.nextDouble();
		System.out.print("what's the breath : ");
		double breath = sc.nextDouble();
		double perimeter = (length + breath) * 2; 
		System.out.println("perimeter : " + perimeter);

	}

}
