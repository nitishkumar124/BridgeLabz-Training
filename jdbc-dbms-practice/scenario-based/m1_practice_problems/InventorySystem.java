package m1_practice_problems;
import java.util.*;

abstract class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    abstract void display();

    double total() {
        return price * quantity;
    }
}

class Electronics extends Product {
    int warranty;

    Electronics(String n, double p, int q, int w) {
        super(n, p, q);
        warranty = w;
    }

    void display() {
        System.out.println(name + " - Price: " + price + ", Quantity: " + quantity + ", Warranty: " + warranty + " months");
    }
}

class Clothing extends Product {
    String size;

    Clothing(String n, double p, int q, String s) {
        super(n, p, q);
        size = s;
    }

    void display() {
        System.out.println(name + " - Price: " + price + ", Quantity: " + quantity + ", Size: " + size);
    }
}

public class InventorySystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Product> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }

            String[] p = line.split(", ");

            if (p[0].equals("Electronics")) {
                list.add(new Electronics(p[1], Double.parseDouble(p[2]), Integer.parseInt(p[3]), Integer.parseInt(p[4])));
            } else {
                list.add(new Clothing(p[1], Double.parseDouble(p[2]), Integer.parseInt(p[3]), p[4]));
            }

            System.out.println("Product added to inventory: " + p[1]);
        }

        System.out.println("Inventory:");
        double total = 0;

        for (Product pr : list) {
            pr.display();
            total += pr.total();
        }

        System.out.printf("Total value of the inventory: %.2f\n", total);
    }
}