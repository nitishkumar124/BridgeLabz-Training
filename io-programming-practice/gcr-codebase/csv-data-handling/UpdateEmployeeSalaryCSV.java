package csv_data_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateEmployeeSalaryCSV {

    public static void main(String[] args) {

        String inputFile = "employees.csv";
        String outputFile = "employees_updated.csv";

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileWriter writer = new FileWriter(outputFile)
        ) {

            String line;

            line = br.readLine();
            writer.write(line + "\n");

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String department = data[2];
                double salary = Double.parseDouble(data[3]);

                if (department.equalsIgnoreCase("IT")) {
                    salary = salary + (salary * 0.10);
                }

                writer.write(
                        data[0] + "," +
                        data[1] + "," +
                        data[2] + "," +
                        salary + "\n"
                );
            }

            System.out.println("Employee salaries updated successfully.");
            System.out.println("Updated file created: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error processing CSV file");
            e.printStackTrace();
        }
    }
}
