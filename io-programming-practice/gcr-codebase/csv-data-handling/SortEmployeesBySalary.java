package csv_data_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortEmployeesBySalary {

    public static void main(String[] args) {

        String filePath = "employees.csv";
        List<String[]> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                employees.add(data);
            }

            Collections.sort(employees, new Comparator<String[]>() {
                @Override
                public int compare(String[] e1, String[] e2) {
                    double salary1 = Double.parseDouble(e1[3]);
                    double salary2 = Double.parseDouble(e2[3]);
                    return Double.compare(salary2, salary1); // descending
                }
            });

            System.out.println("Top 5 Highest-Paid Employees");

            int limit = Math.min(5, employees.size());

            for (int i = 0; i < limit; i++) {
                String[] emp = employees.get(i);
                System.out.println("ID         : " + emp[0]);
                System.out.println("Name       : " + emp[1]);
                System.out.println("Department : " + emp[2]);
                System.out.println("Salary     : " + emp[3]);
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file");
            e.printStackTrace();
        }
    }
}
