package reflection;
import java.lang.reflect.*;
import java.util.Scanner;
public class ClassInformation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter class name: ");
		String className = sc.nextLine();
		try {
			Class<?> cls = Class.forName(className);
			System.out.println("\nClass Name: " +  cls.getName());
			
			System.out.println("\nMethods");
            Method[] methods = cls.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println(m.getName());
            }
            
            System.out.println("\nFields");
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                System.out.println(f.getName());
            }

            System.out.println("\nConstructors");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> c : constructors) {
                System.out.println(c);
            }
		}catch(ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		sc.close();
	}
}
