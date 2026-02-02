package csv_data_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {

    public static void main(String[] args) {

        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "students_merged.csv";

        Map<String, String[]> studentMap = new HashMap<>();

        try (
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            FileWriter writer = new FileWriter(outputFile)
        ) {

            String line;

            br1.readLine();

            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                studentMap.put(data[0], new String[]{data[1], data[2]});
            }

            writer.write("ID,Name,Age,Marks,Grade\n");

            br2.readLine();

            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];

                if (studentMap.containsKey(id)) {
                    String[] studentInfo = studentMap.get(id);

                    writer.write(
                        id + "," +
                        studentInfo[0] + "," +
                        studentInfo[1] + "," +
                        data[1] + "," +
                        data[2] + "\n"
                    );
                }
            }

            System.out.println("CSV files merged successfully.");
            System.out.println("Output file created: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error merging CSV files");
            e.printStackTrace();
        }
    }
}
