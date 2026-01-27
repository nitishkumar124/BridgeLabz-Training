package java_exceptions;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("h.txt");
			int ch;
			
			while((ch = fis.read()) != -1) {
				System.out.print((char)ch);
			}
			fis.close();
		}catch(IOException e) {
			System.out.println("File not found.");
		}
	}
}
