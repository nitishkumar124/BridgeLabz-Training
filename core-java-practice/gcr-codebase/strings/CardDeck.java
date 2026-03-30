package level3;
import java.util.Scanner;

public class CardDeck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        String[] deck = initializeDeck(suits, ranks);

        shuffleDeck(deck);

        System.out.print("Enter the number of players: ");
        int x = sc.nextInt();
        System.out.print("Enter the number of cards per player: ");
        int n = sc.nextInt();

        String[][] players = distributeCards(deck, x, n);
        if (players != null) {
            printPlayersCards(players);
        }

        sc.close();
    }

    public static String[] initializeDeck(String[] suits, String[] ranks) {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    public static String[][] distributeCards(String[] deck, int x, int n) {
        if (x * n > deck.length) {
            System.out.println("Error: Not enough cards in the deck for " + x + " players.");
            return null;
        }

        String[][] players = new String[x][n];
        int deckIndex = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < n; j++) {
                players[i][j] = deck[deckIndex++];
            }
        }
        return players;
    }

    public static void printPlayersCards(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + "'s Hand:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("- " + players[i][j]);
            }
        }
    }
}