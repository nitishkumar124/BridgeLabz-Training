package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Repeatable(BugReports.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class BugTracker {

    @BugReport(description = "NullPointerException when input is null")
    @BugReport(description = "Performance issue with large data set")
    public void processData() {
        System.out.println("Processing data...");
    }
}

public class RepeatableAnnotationDemo {

    public static void main(String[] args) throws Exception {

        BugTracker tracker = new BugTracker();
        Method method = tracker.getClass().getMethod("processData");

        BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);

        for (BugReport bug : bugReports) {
            System.out.println("Bug Description: " + bug.description());
        }
    }
}
