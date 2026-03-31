package multi_threading.thread_state_monitoring_system;

public class ThreadStateMonitoringSystem {

    public static void main(String[] args) throws InterruptedException {

        TaskRunner task1 = new TaskRunner("Task-1");
        TaskRunner task2 = new TaskRunner("Task-2");

        StateMonitor monitor = new StateMonitor(task1, task2);

        System.out.println("[Main] " + task1.getName() + " initial state: " + task1.getState());
        System.out.println("[Main] " + task2.getName() + " initial state: " + task2.getState());

        monitor.start();

        task1.start();
        task2.start();

        task1.join();
        task2.join();
        monitor.join();

        System.out.println("\nMonitoring completed.");
    }
}
