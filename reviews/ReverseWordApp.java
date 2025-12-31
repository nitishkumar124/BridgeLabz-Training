import java.util.Scanner;

public class ReverseWordApp {

  // UC1
  static String removeExtraSpaces(String text) {
    return text.trim();
  }

  // UC2
  static String[] separateWords(String trimmedText) {
    return trimmedText.split(" ");
  }

  // method to display words
  static void displayWords(String[] words) {
    System.out.println("\nwords:");
    for (String word : words){
      System.out.println(word);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String text = sc.nextLine();

    String trimmedText = removeExtraSpaces(text);
    System.out.println("text after extra spaces removed: " + trimmedText);

    String[] words = separateWords(trimmedText);
    displayWords(words);

  }
}