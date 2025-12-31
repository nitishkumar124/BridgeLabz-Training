import java.util.Scanner;

public class ReverseWordApp {

  // UC1: remove leading and trailing whitespaces
  static String removeExtraSpaces(String text) {
    return text.trim();
  }

  // UC2: separate words
  static String[] separateWords(String trimmedText) {
    return trimmedText.split(" ");
  }

  // UC3: reverse word
  static String reverseWord(String word) {
    String reversedWord = "";
    int i = word.length() - 1;
    while (i >= 0) {
      reversedWord += word.charAt(i);
      i--;
    }
    return reversedWord;
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