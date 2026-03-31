package m1_practice_problems;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ShipmentValidator {
	
	static Set<String> validModes = new HashSet<>(Arrays.asList(
			"AIR", "SEA", "ROAD", "RAIL", "EXPRESS", "FREIGHT"));
	
	static Set<String> validStatus = new HashSet<>(Arrays.asList(
            "DELIVERED", "CANCELLED", "IN_TRANSIT"));

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < n; i++) {
			String record = sc.nextLine();
			if(isValid(record)) {
				System.out.println("COMPLIANT RECORD");
			}else {
				System.out.println("NON-COMPLAINT RECORD");
			}
		}
	}
	
	public static boolean isValid(String record) {
		String[] parts = record.split("\\|");
		if (parts.length != 5) return false;
		
		return validateCode(parts[0]) &&
				validateDate(parts[1]) &&
				 validateMode(parts[2]) &&
	               validateWeight(parts[3]) &&
	               validateStatus(parts[4]);
	}
	
	 public static boolean validateCode(String code) {
	        if (!code.matches("SHIP-[1-9][0-9]{5}")) return false;

	        String digits = code.substring(5);

	        int count = 1;
	        for (int i = 1; i < digits.length(); i++) {
	            if (digits.charAt(i) == digits.charAt(i - 1)) {
	                count++;
	                if (count > 3) return false;
	            } else {
	                count = 1;
	            }
	        }
	        return true;
	    }

	    // 2. Date
	    public static boolean validateDate(String date) {
	        try {
	            LocalDate d = LocalDate.parse(date);
	            int year = d.getYear();
	            return year >= 2000 && year <= 2099;
	        } catch (DateTimeParseException e) {
	            return false;
	        }
	    }

	    // 3. Mode
	    public static boolean validateMode(String mode) {
	        return validModes.contains(mode);
	    }

	    // 4. Weight
	    public static boolean validateWeight(String weight) {
	        if (!weight.matches("(0|[1-9]\\d{0,5})(\\.\\d{1,2})?")) return false;

	        try {
	            double val = Double.parseDouble(weight);
	            return val > 0 && val <= 999999.99;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    // 5. Status
	    public static boolean validateStatus(String status) {
	        return validStatus.contains(status);
	    }
}
