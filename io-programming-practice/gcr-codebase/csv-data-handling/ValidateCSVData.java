package csv_data_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSVData {

    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private static final String PHONE_REGEX =
            "^[0-9]{10}$";

    public static void main(String[] args) {

        String filePath = "users.csv";

        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Pattern phonePattern = Pattern.compile(PHONE_REGEX);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            int rowNumber = 0;

            br.readLine();

            while ((line = br.readLine()) != null) {
                rowNumber++;

                String[] data = line.split(",");

                String email = data[2];
                String phone = data[3];

                boolean emailValid = emailPattern.matcher(email).matches();
                boolean phoneValid = phonePattern.matcher(phone).matches();

                if (!emailValid || !phoneValid) {
                    System.out.println("Invalid Row Found (Row " + rowNumber + "):");
                    System.out.println(line);

                    if (!emailValid) {
                        System.out.println("Invalid Email Format");
                    }
                    if (!phoneValid) {
                        System.out.println("Invalid Phone Number");
                    }
                    System.out.println();
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file");
            e.printStackTrace();
        }
    }
}
