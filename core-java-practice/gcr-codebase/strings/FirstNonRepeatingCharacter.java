package level3;

import java.util.*;

public class FirstNonRepeatingCharacter {
//	Create a Method to find the first non-repeating character in a string using the charAt() method and return the character. The logic used here is as follows:
//		Create an array to store the frequency of characters in the text. ASCII values of characters are used as indexes in the array to store the frequency of each character. There are 256 ASCII characters
//		Loop through the text to find the frequency of characters in the text
//		Loop through the text to find the first non-repeating character in the text by checking the frequency of each character
//		In the main function take user inputs, call user-defined methods, and displays result. 

	static int[] frequency(String s) {
		int[] freq = new int[256];

		for (int i = 0; i < s.length(); i++)
			freq[(int) (s.charAt(i))]++;

		return freq;
	}
	
	static void firstNonRepeating(int[] freq, String s) {
		char ch = ' ';
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (freq[(int) temp] == 1) {
				ch = temp;
				break;
			}
		}
		if (ch != ' ')System.out.println("First non-repeating character : " + ch);
		else System.out.println("No non-repeating character found.");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter some text : ");
		String s = sc.nextLine();
		firstNonRepeating(frequency(s), s);
		sc.close();
	}
}
