package level3;

import java.util.*;

public class CharacterFrequency {
	static int[] frequency(String s) {
		int[] freq = new int[256];

		for (int i = 0; i < s.length(); i++)
			freq[(int) (s.charAt(i))]++;

		return freq;
	}

	static int count(int[] freq) {
		int c = 0;
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] != 0)
				c++;
		}
		return c;
	}

	static String[][] characterFrequency(int[] freq) {
		String[][] arr = new String[count(freq)][2]; // [0] -> character, [1] -> frequency
		int index = 0;
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] != 0) {				
				arr[index][0] = String.valueOf((char)i);
				arr[index++][1] = String.valueOf(freq[i]);
			}
		}

		return arr;
	}

	static void print(String[][] arr) {
		System.out.println("character | frequency");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][0] + " | " + arr[i][1]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter some text : ");
		String s = sc.nextLine();
		print(characterFrequency(frequency(s)));
		sc.close();
	}
}
