package week4;
import java.util.*;
public class LengthOfLastWord_58 {

	public static void main(String[] args) {
		String s = " hello world  ";
		System.out.println(lengthOfLastWord(s));
	}
	
	public static int lengthOfLastWord(String s) {
        int i = s.length() - 1;

        while (s.charAt(i) == ' ') i--;

        String lastWord = "";

        while (i >= 0 && s.charAt(i) != ' ') lastWord = s.charAt(i--) + lastWord;
        return lastWord.length();
    }
}

