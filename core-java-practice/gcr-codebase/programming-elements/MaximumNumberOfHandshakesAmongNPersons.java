package level1;

import java.util.Scanner;

public class MaximumNumberOfHandshakesAmongNPersons {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number of persons : ");
		int n = sc.nextInt();
		int totalHandshakes = (n * (n - 1)) / 2 ;
		System.out.println("total number of possible handshakes : " + totalHandshakes);
	}

}
