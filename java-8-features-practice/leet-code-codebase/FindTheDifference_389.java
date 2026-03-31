package week6;

public class FindTheDifference_389 {

	public static void main(String[] args) {
		String s = "abcd";
		String t = "abcde";
		System.out.println(findTheDifference(s, t));
		
	}

	public static char findTheDifference(String s, String t) {
		int[] fre = new int[26];

		for (int i = 0; i < t.length(); i++) {
			if (i < s.length())
				fre[s.charAt(i) - 'a']++;
			fre[t.charAt(i) - 'a']--;
		}

		for (int i = 0; i < 26; i++) {
			if (fre[i] != 0)
				return (char) ('a' + i);
		}
		return 'z';
	}
}
