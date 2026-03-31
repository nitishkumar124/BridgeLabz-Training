package functional_interfaces;
public class BackgroundJob {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Job running...");
        new Thread(task).start();
    }
}
