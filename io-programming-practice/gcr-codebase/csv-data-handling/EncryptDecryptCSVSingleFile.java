package csv_data_handling;

import java.io.*;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecryptCSVSingleFile {

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "1234567890123456"; 

    public static void main(String[] args) {

        String filePath = "employees_secure.csv";

        try (FileWriter writer = new FileWriter(filePath)) {

            writer.write("ID,Name,Email,Salary\n");

            writer.write("201,Aryan," +
                    encrypt("aryan@gmail.com") + "," +
                    encrypt("55000") + "\n");

            writer.write("202,Riya," +
                    encrypt("riya@gmail.com") + "," +
                    encrypt("48000") + "\n");

            System.out.println("Encrypted CSV written successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            br.readLine(); 

            System.out.println("\nDecrypted Data:");

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String email = decrypt(data[2]);
                String salary = decrypt(data[3]);

                System.out.println("ID     : " + data[0]);
                System.out.println("Name   : " + data[1]);
                System.out.println("Email  : " + email);
                System.out.println("Salary : " + salary);
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String encrypt(String value) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    private static String decrypt(String encryptedValue) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decoded = Base64.getDecoder().decode(encryptedValue);
        return new String(cipher.doFinal(decoded));
    }
}
