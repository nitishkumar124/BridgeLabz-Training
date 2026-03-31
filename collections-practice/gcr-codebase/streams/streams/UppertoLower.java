package streams;

import java.io.*;

public class UppertoLower {

    public static void main(String[] args) {

        String inputFile =
            "input.txt";

        String outputFile =
            "output.txt";

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {
            int ch;

            while ((ch = br.read()) != -1) {
                bw.write(Character.toLowerCase((char) ch));
            }

            System.out.println("File converted successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

