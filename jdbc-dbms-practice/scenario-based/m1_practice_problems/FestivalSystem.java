package m1_practice_problems;
import java.util.*;

abstract class Festival {
    String name, location, date;

    Festival(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    abstract void display();
}

class MusicFestival extends Festival {
    String headliner, genre;
    int price;

    MusicFestival(String n, String l, String d, String h, String g, int p) {
        super(n, l, d);
        headliner = h;
        genre = g;
        price = p;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Headliner: " + headliner);
        System.out.println("Music Genre: " + genre);
        System.out.println("Ticket Price: " + price);
    }
}

class FoodFestival extends Festival {
    String cuisine;
    int stalls, fee;

    FoodFestival(String n, String l, String d, String c, int s, int f) {
        super(n, l, d);
        cuisine = c;
        stalls = s;
        fee = f;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Cuisine: " + cuisine);
        System.out.println("Number of Stalls: " + stalls);
        System.out.println("Entry Fee: " + fee);
    }
}

class ArtFestival extends Festival {
    String type;
    int artists, fee;

    ArtFestival(String n, String l, String d, String t, int a, int f) {
        super(n, l, d);
        type = t;
        artists = a;
        fee = f;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Art Type: " + type);
        System.out.println("Number of Artists: " + artists);
        System.out.println("Exhibition Fee: " + fee);
    }
}

public class FestivalSystem {
    static Map<String, Festival> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            if (line.equals("EXIT")) break;

            String[] p = line.split(" ");

            if (p[0].equals("ADD_FESTIVAL")) {
                String type = p[1];

                if (type.equals("MUSIC")) {
                    map.put(p[2], new MusicFestival(p[2], p[3], p[4], p[5], p[6], Integer.parseInt(p[7])));
                } else if (type.equals("FOOD")) {
                    map.put(p[2], new FoodFestival(p[2], p[3], p[4], p[5], Integer.parseInt(p[6]), Integer.parseInt(p[7])));
                } else {
                    map.put(p[2], new ArtFestival(p[2], p[3], p[4], p[5], Integer.parseInt(p[6]), Integer.parseInt(p[7])));
                }
            }

            else if (p[0].equals("DISPLAY_DETAILS")) {
                map.get(p[1]).display();
            }
        }
    }
}