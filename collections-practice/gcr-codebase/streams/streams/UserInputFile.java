package streams;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserInputFile {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        FileWriter fw = null;

        try {
            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            String age = br.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            String filePath =
                "user_data.txt";

            fw = new FileWriter(filePath);

            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Language: " + language + "\n");

            System.out.println("\nData saved successfully!");

        } catch (IOException e) {
            System.out.println("Error occurred while reading or writing data.");
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
