package m1_practice_problems;
import java.util.*;

public class EmailValidator {

    static Set<String> departments = new HashSet<>(
            Arrays.asList("sales", "marketing", "IT", "product")
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String email = sc.nextLine();

            if (isValid(email)) {
                System.out.println("Access Granted");
            } else {
                System.out.println("Access Denied");
            }
        }
    }

    public static boolean isValid(String email) {

        // No spaces
        if (email.contains(" ")) return false;

        String regex = "^[a-z]{3,}\\.[a-z]{3,}\\+\\d{4,}@[a-zA-Z]+\\.company\\.com$";

        if (!email.matches(regex)) return false;

        // Extract department
        String dept = email.split("@")[1].split("\\.")[0];

        return departments.contains(dept);
    }
}