package practice_problems;

import java.util.*;

public class SnakeAndLadder {

	static int rollDice() {
		return (int) Math.round(Math.random() * 10) % 6 + 1;
	}

	static int checkOptions() {
		int m = (int) Math.round(Math.random() * 10) % 3 + 1;
		return m;
	}

	static int snake(int position) {
		if (position < 32) {
			System.out.println("no snake or ladder.");
			return position;
		}
		int p = 0;
		while (true) {
			int s = (int) Math.round(Math.random() * 10) % 7 + 3;
			int t = (int) Math.round(Math.random() * 10) % 7;
			p = s * 10 + t;
			if (p <= position)
				break;
		}
		System.out.println("a snake bite you.");
		return position - p;
	}

	static int ladder(int position) {
		if (position > 60) {
			System.out.println("no snake or ladder.");
			return position;
		}
		int p = 0;
		while (true) {
			int s = (int) Math.round(Math.random() * 10) % 9 + 1;
			int t = (int) Math.round(Math.random() * 10) % 10;
			p = s * 10 + t;
			if (p + position <= 100)
				break;
		}
		System.out.println("you got a ladder.");
		return position + p;
	}

	static int[] play(int position, int diceRollCount, int turn) {
		Scanner sc = new Scanner(System.in);
		int flag = turn;

		while (flag == turn) {
			System.out.println("press enter to roll the dice.");
			sc.nextLine();

			int r = rollDice();
			diceRollCount++;
			System.out.println("dice roll : " + r);
			position += r;

			System.out.println("current position : " + position);

			int op = checkOptions();
			switch (op) {
			case 1: // snake
				position = snake(position);
				flag = 0;
				break;
			case 2: // ladder
				position = ladder(position);
				break;
			case 3: // no play
				flag = 0;
				System.out.println("no snake or ladder.");
				break;
			}

			System.out.println("current position : " + position + "\n");
			if (position == 100) {
				break;
			}

		}
		return new int[] { position, diceRollCount };
	}

	static void playSingle() {
		int position = 0, diceRollCount = 0;
		int[] r = play(position, diceRollCount, 0);
		position = r[0];
		diceRollCount = r[1];
		if (position == 100) {
			System.out.println("\nYou won.");
			System.out.println("Dice roll count : " + diceRollCount);
		}

	}

	static void playDual() {
		int diceRollCount1 = 0, position1 = 0;
		int diceRollCount2 = 0, position2 = 0;
		int turn = 1;
		while (true) {
			if (turn == 1) {
				System.out.println("\nPlayer 1 : ");
				int[] r = play(position1, diceRollCount1, 1);
				position1 = r[0];
				diceRollCount1 = r[1];
				turn = 2;
				if (position1 == 100) {
					System.out.println("\nPlayer 1 won.");
					System.out.println("Dice roll count : " + diceRollCount1);
					break;
				}
			} else {
				System.out.println("\nPlayer 2 : ");
				int[] r = play(position2, diceRollCount2, 2);
				position2 = r[0];
				diceRollCount2 = r[1];
				turn = 1;
				if (position2 == 100) {
					System.out.println("\nPlayer 2 won.");
					System.out.println("Dice roll count : " + diceRollCount2);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
//		playSingle();
		playDual();
	}
}
