package level1;

public class SpringSeason {

	public static void main(String[] args) {
		int month = Integer.parseInt(args[0]);
		int day = Integer.parseInt(args[1]);
		if (month == 3) {
			if (day >= 20)
				System.out.println("Its a Spring Season");
			else
				System.out.println("Not a spring Season");
		} else if (month == 4 || month == 5) {
			System.out.println("Its a Spring Season");
		} else if (month == 6) {
			if (day <= 20)
				System.out.println("Its a Spring Season");
			else
				System.out.println("Not a Spring Season");
		} else {
			System.out.println("Not a Spring Season");
		}
	}
}