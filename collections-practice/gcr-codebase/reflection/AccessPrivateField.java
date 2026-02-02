package reflection;
import java.lang.reflect.Field;
public class AccessPrivateField {
	public static void main(String[] args) throws Exception{
		Person p = new Person();
		
		Class<?> cls = p.getClass();
		Field field = cls.getDeclaredField("age");
		field.setAccessible(true);
		
		field.set(p, 25);
		
		int ageValue = (int) field.get(p);
		
		System.out.println("Age: " + ageValue);
	}
}
class Person{
	@SuppressWarnings("unused")
	private int age = 20;
}
