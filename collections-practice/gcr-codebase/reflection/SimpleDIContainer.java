package reflection;
import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

class Service {
    void serve() {
        System.out.println("Service Executed");
    }
}

class Client {

    @Inject
    Service service;

    void doWork() {
        service.serve();
    }
}

public class SimpleDIContainer {

    public static void injectDependencies(Object obj) throws Exception {

        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Object dep =
                    field.getType()
                         .getDeclaredConstructor()
                         .newInstance();
                field.setAccessible(true);
                field.set(obj, dep);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Client client = new Client();
        injectDependencies(client);
        client.doWork();
    }
}
