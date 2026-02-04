package functional_interfaces;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DateFormatter {
	interface DateUtils{
		static String format(LocalDate d, String p) {
			return d.format(DateTimeFormatter.ofPattern(p));
		}
	}
	public static void main(String[] args) {
		System.out.println(DateUtils.format(LocalDate.now(), "dd-MM-yyyy"));
	}
}
