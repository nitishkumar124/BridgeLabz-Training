package csv_data_handling;

import java.io.FileWriter;
import java.io.IOException;

public class WriteEmployeeCSV {

    public static void main(String[] args) {

        String filePath = "employees.csv";

        try (FileWriter writer = new FileWriter(filePath)) {

            writer.write("ID,Name,Department,Salary\n");

            writer.write("201,Aryan,IT,55000\n");
            writer.write("202,Riya,HR,48000\n");
            writer.write("203,Karan,Finance,60000\n");
            writer.write("204,Neha,Marketing,52000\n");
            writer.write("205,Rahul,Operations,50000\n");

            System.out.println("Data written successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to CSV file");
            e.printStackTrace();
        }
    }
}
