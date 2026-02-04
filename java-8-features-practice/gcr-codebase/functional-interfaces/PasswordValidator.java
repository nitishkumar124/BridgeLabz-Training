package functional_interfaces;

public class PasswordValidator {
	interface SecurityUtils{
		static boolean isStrong(String pass) {
			return pass.length() >= 8 &&
					pass.matches(".*[A-Z].*") &&
					pass.matches(".*[0-9].*");
		}
	}
	public static void main(String[] args) {
		System.out.println(SecurityUtils.isStrong("Ram1245"));
	}
}
