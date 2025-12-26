package level3;

import java.util.*;

public class UniqueCharacterFrequency {

	static int[] frequency(String s) {
		int[] freq = new int[256];

		for (int i = 0; i < s.length(); i++)
			freq[(int) s.charAt(i)]++;

		return freq;
	}

	static char[] uniqueCharacter(int[] freq) {
		int count = 0;
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] == 1)
				count++;
		}

		char[] unique = new char[count];

		int index = 0;
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] == 1) {
				unique[index++] = (char) i;
			}
		}
		return unique;
	}
	
	static void print(char[] unique) {
		System.out.println("unique charcaters : ");
		for (int i = 0; i < unique.length; i++) {
			System.out.println(unique[i]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter some text : ");
		String s = sc.nextLine();
		print(uniqueCharacter(frequency(s)));
		sc.close();
	}
}
