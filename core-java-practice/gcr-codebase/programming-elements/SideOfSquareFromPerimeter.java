package level1;

import java.util.Scanner;

public class SideOfSquareFromPerimeter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the square perimeter : ");
		double perimeter = sc.nextDouble();
		
		double side = perimeter / 4;
		
		System.out.println("The length of the side of the square is " + side + " whose perimeter is " + perimeter
);

	}

}
