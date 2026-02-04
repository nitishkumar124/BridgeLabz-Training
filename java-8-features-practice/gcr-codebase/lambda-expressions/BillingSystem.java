package lambda_expressions;
import java.util.*;
import java.util.stream.Collectors;

class Invoice {
    private String transactionId;
    private double taxRate = 0.05; // Default 5%

    // Constructor that matches the stream input
    public Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice[ID=" + transactionId + ", Status=GENERATED]";
    }
}

public class BillingSystem {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList("TX-9001", "TX-9002", "TX-9003");

        // Use a constructor reference to instantiate objects
        List<Invoice> invoiceList = transactionIds.stream()
            .map(Invoice::new)  // Equivalent to: id -> new Invoice(id)
            .collect(Collectors.toList());

        System.out.println("--- Generated Invoices ---");
        invoiceList.forEach(System.out::println);
    }
}