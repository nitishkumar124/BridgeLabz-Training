package reflection;
import java.lang.reflect.*;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello World!");
    }
}

public class LoggingProxy {

    public static void main(String[] args) {

        Greeting target = new GreetingImpl();

        Greeting proxy = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[]{Greeting.class},
            (obj, method, args1) -> {
                System.out.println("Calling method: " + method.getName());
                return method.invoke(target, args1);
            }
        );

        proxy.sayHello();
    }
}
