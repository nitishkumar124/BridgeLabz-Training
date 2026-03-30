package week2;

import java.util.*;

public class RomanToInteger {
	public static int getVal(char ch) {
		switch (ch) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the roman number: ");
		String str = sc.next();
		int pre = Integer.MAX_VALUE;
		int num = 0;
		for (char ch : str.toCharArray()) {
			int temp = getVal(ch);
			if (pre < temp) num += temp - 2 * pre;
			else num += temp;
			pre = temp;
		}
		System.out.println(num);
	}
}