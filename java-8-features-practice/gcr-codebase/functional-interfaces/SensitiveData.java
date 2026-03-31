package functional_interfaces;

public class SensitiveData {
	interface SensitivData { }
	static class UserInfo implements SensitivData{
		String password = "secret";
	}
	public static void main(String[] args) {
		UserInfo u = new UserInfo();
		if( u instanceof SensitivData) {
			System.out.println("Encrypt this data");
		}
	}
}
