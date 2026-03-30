package practice_problems;
import java.util.*;
public class VoulmeOfCylinder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("what's the radius : ");
		double radius = sc.nextDouble()	;
		System.out.print("what's the height : ");
		double height = sc.nextDouble()	;
		double volume = Math.PI * (radius * radius) * height;
		System.out.print("Volume of cylinder : " + volume);

	}

}
