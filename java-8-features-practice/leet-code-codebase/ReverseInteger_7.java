package week6;
import java.util.*;
public class ReverseInteger_7 {

	public static void main(String[] args) {
		int x = 534236469;
		System.out.println("Reversed Integer: " + reverse(x));
	}
	
	public static int reverse(int x) {
        double rev = 0;
        
        int temp = x;

        while (temp != 0) {
            rev *= 10;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
            rev += temp % 10;
            temp /= 10;
        }

        return (int) rev;
    }
}

