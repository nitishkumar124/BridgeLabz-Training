package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Service {

    @ImportantMethod
    public void startService() {
        System.out.println("Service started");
    }

    @ImportantMethod(level = "MEDIUM")
    public void stopService() {
        System.out.println("Service stopped");
    }

    public void helperMethod() {
        System.out.println("Helper method");
    }
}

public class ImportantMethodDemo {

    public static void main(String[] args) {

        Class<Service> clazz = Service.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(ImportantMethod.class)) {

                ImportantMethod im = method.getAnnotation(ImportantMethod.class);

                System.out.println("Method Name : " + method.getName());
                System.out.println("Importance  : " + im.level());
                System.out.println();
            }
        }
    }
}
