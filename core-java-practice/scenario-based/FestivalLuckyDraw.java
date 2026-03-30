package practice_problems;

import java.util.*;
public class FestivalLuckyDraw {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Enter the number of your choice (or -1 to exit) : ");
			int num = sc.nextInt();
			if (num==-1) {
				System.out.println("You have Exited");
				break;
			}
			if(num<=0) {
				System.out.println("Invalid! Try Again");
			}
			if (num%3==0 && num%5==0) {
				System.out.println("Congratulations! You have won a gift");
			}else {
				System.out.println("Better Luck Next Time!");
			}
		}
		sc.close();
	}
}