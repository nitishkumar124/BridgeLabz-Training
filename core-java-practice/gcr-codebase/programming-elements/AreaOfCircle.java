package practice_problems;
import java.util.*;
public class AreaOfCircle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("what's the radius of circle : ");
		double radius = sc.nextDouble();
		double area = Math.PI * (radius * radius);
		System.out.print("Area of Circle : " + area);
	}

}
