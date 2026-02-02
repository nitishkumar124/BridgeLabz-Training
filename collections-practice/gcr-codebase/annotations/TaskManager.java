package annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)          
@interface TaskInfo {
    int priority();
    String assignedTo();
}

public class TaskManager {

    @TaskInfo(priority = 1, assignedTo = "Aryansh")
    public void completeTask() {
        System.out.println("Task is being completed");
    }

    public static void main(String[] args) {

        try {
            TaskManager manager = new TaskManager();
            Method method = manager.getClass().getMethod("completeTask");

            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

            if (taskInfo != null) {
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }

            manager.completeTask();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
