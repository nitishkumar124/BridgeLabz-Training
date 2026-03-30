package week1;
import java.util.Scanner;

public class RotateString_796 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string s: ");
        String s = scanner.nextLine();

        System.out.print("Enter string goal: ");
        String goal = scanner.nextLine();

        boolean result = canRotate(s, goal);
        System.out.println("Result: " + result);

        scanner.close();
    }

    public static boolean canRotate(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        String doubledS = s + s;

        return doubledS.contains(goal);
    }
}