package regex;

import java.util.regex.Pattern;

public class ValidateIPAddress {
	public static void main(String[] args) {

		String ip = "192.168.1.1";
		String regex = "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}" + "(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";

		System.out.println(Pattern.matches(regex, ip) ? "Valid IP" : "Invalid IP");
	}

}
