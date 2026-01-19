package week3;
import java.util.*;
public class ExcelSheetColumnTitle_168 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter column number: ");
		int col = sc.nextInt();
		System.out.println("Column title: " + convertToTitle(col));
		sc.close();
	}
	
	public static String convertToTitle(int columnNumber) {
        String result = "";
        while (columnNumber > 0) {
            int d = columnNumber % 26;
            if (d == 0) {
                result = 'Z' + result;
                columnNumber--;
            } else
                result = (char) ('A' - 1 + d) + result;
            columnNumber /= 26;
        }
        return result;
    }
}

