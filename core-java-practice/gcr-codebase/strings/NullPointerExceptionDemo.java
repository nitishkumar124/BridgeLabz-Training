package level1;

public class NullPointerExceptionDemo {

	public static void main(String[] args) {
		handleException();

	}
	
	public static void generateException() {
		String text = null;
		int s = text.length();
	}
	
	public static void handleException() {
		try {
			generateException();
		} catch(NullPointerException e) {
			System.out.print("error handleled");
		}
	}

}
