package level1;

import java.util.*;

public class Circle {

	double radius;

	Circle() {
		this(10);
	}

	Circle(double radius) {
		this.radius = radius;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the circle radius : ");
		double radius = sc.nextDouble();

		Circle c1 = new Circle();
		Circle c2 = new Circle(radius);

		sc.close();
	}
}
