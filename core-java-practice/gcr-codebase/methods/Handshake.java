package level1;
import java.util.*;
public class Handshake {

	static int findNumberOfHandshakes(int n) {
		return (n * (n - 1)) / 2;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of students : ");
		int n = sc.nextInt();
		
		int handshakes = findNumberOfHandshakes(n);
		
		System.out.println("Total possible handshakes among " + n + " students : " + handshakes);

		sc.close();
	}
}

