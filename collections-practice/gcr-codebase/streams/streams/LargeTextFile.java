package streams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LargeTextFile {

    public static void main(String[] args) throws IOException {

        String filePath =
            "large_log.txt";

        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));

        for (int i = 1; i <= 5_000_000; i++) {
            bw.write("INFO Line number " + i);
            bw.newLine();

            if (i % 10 == 0) {
                bw.write("Error" + i);
                bw.newLine();
            }
        }

        bw.close();
        System.out.println("File created successfully");
    }
}

