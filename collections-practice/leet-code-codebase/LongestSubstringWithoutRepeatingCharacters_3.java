package week4;
import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters_3 {

	public static void main(String[] args) {
		String s = "abcabcbb";
		int result = lengthOfLongestSubstring(s);
		System.out.println("Length of Longest Substring Without Repeating Characters: " + result);
	}
	
	public static int lengthOfLongestSubstring(String s) {
        String[] fre = new String[256];
        int max = 0, temp = 0;

        for (int i = 0; i < s.length(); ) {
            char ch = s.charAt(i);
            if (fre[(int) ch] != null) {
                i = Integer.parseInt(fre[(int) ch]) + 1;
                fre = new String[256];
                max = Math.max(max, temp);
                temp = 0;
            } else {
                fre[(int) ch] = String.valueOf(i);
                i++;
                temp++;
            }
        } 
        return Math.max(max, temp);
    }
}

