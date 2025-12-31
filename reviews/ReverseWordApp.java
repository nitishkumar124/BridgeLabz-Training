import java.util.Scanner;

public class ReverseWordApp {

  // UC1
  static String removeExtraSpaces(String text) {
    return text.trim();
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String text = sc.nextLine();

    String trimmedText = removeExtraSpaces(text);
    System.out.println("text after extra spaces removed: " + trimmedText);
  }
}