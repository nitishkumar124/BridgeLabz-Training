package multi_threading.thread_state_monitoring_system;

class TaskRunner extends Thread {

    public TaskRunner(String name) {
        super(name);
    }

    @Override
    public void run() {

        try {
            // TIMED_WAITING
            Thread.sleep(2000);

            // RUNNABLE (Computation)
            for (int i = 0; i < 5; i++) {
                System.out.println(getName() + " computing step " + i);
            }

        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted.");
        }
    }
}
