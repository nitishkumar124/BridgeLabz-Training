package csv_data_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadStudentCSV {

    public static void main(String[] args) {

        String filePath = "students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                System.out.println("Student ID : " + data[0]);
                System.out.println("Name       : " + data[1]);
                System.out.println("Age        : " + data[2]);
                System.out.println("Marks      : " + data[3]);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file");
            e.printStackTrace();
        }
    }
}
