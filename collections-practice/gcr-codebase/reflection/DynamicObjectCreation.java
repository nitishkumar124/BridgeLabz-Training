package reflection;
import java.lang.reflect.Constructor;

public class DynamicObjectCreation {

    static class Student {
        int id;
        String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        void display() {
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
        }
    }

    public static void main(String[] args) {

        try {
            Class<?> cls = Student.class;  

            Constructor<?> constructor =
                    cls.getConstructor(int.class, String.class);

            Object obj =
                    constructor.newInstance(101, "Aryansh");

            Student s = (Student) obj;
            s.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
