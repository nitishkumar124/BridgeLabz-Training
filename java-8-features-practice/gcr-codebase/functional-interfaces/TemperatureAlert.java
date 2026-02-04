package functional_interfaces;
import java.util.function.Predicate;
public class TemperatureAlert {
	public static void main(String[] args) {
		Predicate<Double> highTemp = t -> t > 40;
		System.out.println(highTemp.test(45.5));
	}
}
