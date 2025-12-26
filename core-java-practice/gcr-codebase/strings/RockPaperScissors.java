package level2;

import java.util.*;

public class RockPaperScissors {

	static char computerMove() {
		int r = (int) (Math.random() * 10);
		char choice;
		if (r > 6)
			choice = 's';
		else if (r > 3)
			choice = 'p';
		else
			choice = 'r';

		return choice;
	}

	static String play(char user, char computer) {

		switch (user) {
		case 'r':
			switch (computer) {
			case 'r':
				return "draw";
			case 'p':
				return "computer";
			case 's':
				return "user";
			}
		case 'p':
			switch (computer) {
			case 'r':
				return "user";
			case 'p':
				return "draw";
			case 's':
				return "computer";
			}
		case 's':
			switch (computer) {
			case 'r':
				return "computer";
			case 'p':
				return "user";
			case 's':
				return "draw";
			}
		}
		return "draw";
	}

	static char userMove(Scanner sc) {
		char ch;
		while (true) {
			System.out.print("enter 'r' for rock, 'p' for paper and 's' for scissors : ");
			ch = sc.next().charAt(0);
			if (ch == 'r' || ch == 'p' || ch == 's') {
				break;
			} else
				System.out.println("invalid input.");
		}
		return ch;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of games you would like to play : ");
		int n = sc.nextInt();
		int userWins = 0;
		int computerWins = 0;

		for (int i = 0; i < n; i++) {
			int k = i + 1;
			char computer = computerMove();
			char user = userMove(sc);
			String winner = play(user, computer);
			System.out.println("game " + k + " winner : " + winner + "\n");
			if (winner == "user")
				userWins++;
			else if (winner == "computer")
				computerWins++;
		}
		
		System.out.println("\nplayer | wins | win%");
		System.out.println("user | " + userWins + " | " + ((double)(userWins * 100.0) / n));
		System.out.println("computer | " + computerWins + " | " + ((double)(computerWins * 100.0) / n));

		sc.close();
	}
}
