package reflection;
import java.lang.reflect.Method;
public class InvokePrivateMethod {
	public static void main(String[] args) throws Exception {
		Calculator calc = new Calculator();
		
		Class<?> cls = calc.getClass();
		
		Method method = cls.getDeclaredMethod("multiply", int.class, int.class);
		
		method.setAccessible(true);
		
		int result = (int) method.invoke(calc, 6 ,5);
		
		System.out.println("Result: " + result);
	}
}
class Calculator{
	@SuppressWarnings("unused")
	private int multiply(int a, int b) {
		return a*b;
	}
}