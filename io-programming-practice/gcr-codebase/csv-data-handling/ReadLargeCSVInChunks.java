package csv_data_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCSVInChunks {

    public static void main(String[] args) {

        String filePath = "large_data.csv";
        int batchSize = 100;     
        int totalRecords = 0;
        int currentBatchCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            @SuppressWarnings("unused")
			String line;

            br.readLine();

            while ((line = br.readLine()) != null) {

                currentBatchCount++;
                totalRecords++;

                if (currentBatchCount == batchSize) {
                    System.out.println("Processed records so far: " + totalRecords);
                    currentBatchCount = 0; 
                }
            }

            if (currentBatchCount > 0) {
                System.out.println("Processed records so far: " + totalRecords);
            }

            System.out.println("Total records processed: " + totalRecords);

        } catch (IOException e) {
            System.out.println("Error reading large CSV file");
            e.printStackTrace();
        }
    }
}
