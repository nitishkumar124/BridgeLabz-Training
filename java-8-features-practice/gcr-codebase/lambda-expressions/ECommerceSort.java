package lambda_expressions;
import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    int discount;

    Product(String name, double price, double rating, int discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return String.format("%-12s | Price: $%.2f | Rating: %.1f | Discount: %d%%", 
                              name, price, rating, discount);
    }
}

public class ECommerceSort {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Smartphone", 899.99, 4.5, 10),
            new Product("Laptop", 1200.00, 4.8, 5),
            new Product("Headphones", 150.00, 4.2, 30),
            new Product("Smartwatch", 250.00, 4.7, 15)
        );

        // 1. Dynamic Sort by Price (Low to High)
        System.out.println("--- Sort by Price (Ascending) ---");
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        products.forEach(System.out::println);

        // 2. Dynamic Sort by Rating (High to Low)
        System.out.println("\n--- Flash Sale: Highest Rated First ---");
        products.sort(Comparator.comparingDouble((Product p) -> p.rating).reversed());
        products.forEach(System.out::println);

        // 3. Dynamic Sort by Discount (Highest Discount First)
        System.out.println("\n--- Holiday Campaign: Biggest Savings ---");
        products.sort((p1, p2) -> p2.discount - p1.discount);
        products.forEach(System.out::println);
    }
}