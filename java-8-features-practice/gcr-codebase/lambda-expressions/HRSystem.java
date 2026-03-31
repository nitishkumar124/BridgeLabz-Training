package lambda_expressions;
import java.util.*;
import java.util.stream.Collectors;

public class HRSystem {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList(
            "john doe", 
            "jane smith", 
            "michael scott", 
            "pam beesly"
        );

        // Process the names for the HR letter
        List<String> standardizedNames = employees.stream()
            .map(String::toUpperCase) // Method reference to transform each string
            .collect(Collectors.toList());

        System.out.println("--- HR Letter Recipient List ---");
        standardizedNames.forEach(System.out::println);
    }
}