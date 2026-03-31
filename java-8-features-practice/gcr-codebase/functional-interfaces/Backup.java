package functional_interfaces;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Backup implements Serializable {
	int id = 1;
	public static void main(String[] args) {
		System.out.println("Serializable marker used");
	}
}
