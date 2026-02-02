package reflection;
import java.lang.reflect.Method;

class Task {

    public void execute() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Task Executed");
    }
}

public class MethodExecutionTiming {

    public static void main(String[] args) throws Exception {

        Class<?> cls = Task.class;
        Object obj = cls.getDeclaredConstructor().newInstance();

        Method method = cls.getMethod("execute");

        long start = System.nanoTime();
        method.invoke(obj);
        long end = System.nanoTime();

        System.out.println(
            "Execution Time: " + (end - start) + " ns"
        );
    }
}
