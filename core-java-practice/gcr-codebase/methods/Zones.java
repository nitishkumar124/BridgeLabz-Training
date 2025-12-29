package extras1;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
public class Zones {
	public static void main(String[] args) {

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");

        ZonedDateTime gmt = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime ist = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime pst = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        System.out.println("Current Time in GMT : " + gmt.format(format));
        System.out.println("Current Time in IST : " + ist.format(format));
        System.out.println("Current Time in PST : " + pst.format(format));
    }
}