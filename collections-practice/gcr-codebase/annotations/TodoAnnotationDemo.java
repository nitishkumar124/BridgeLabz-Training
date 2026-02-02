package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {

    String task();          

    String assignedTo();    

    String priority() default "MEDIUM";
}

class ProjectModule {

    @Todo(
        task = "Implement user authentication",
        assignedTo = "Aman",
        priority = "HIGH"
    )
    public void loginFeature() {
    }

    @Todo(
        task = "Add password reset functionality",
        assignedTo = "Neha"
    )
    public void passwordReset() {
    }

    @Todo(
        task = "Optimize database queries",
        assignedTo = "Rahul",
        priority = "LOW"
    )
    public void optimizeDB() {
    }
}

public class TodoAnnotationDemo {

    public static void main(String[] args) {

        Class<ProjectModule> clazz = ProjectModule.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(Todo.class)) {

                Todo todo = method.getAnnotation(Todo.class);

                System.out.println("Method Name : " + method.getName());
                System.out.println("Task        : " + todo.task());
                System.out.println("Assigned To : " + todo.assignedTo());
                System.out.println("Priority    : " + todo.priority());
                System.out.println();
            }
        }
    }
}
