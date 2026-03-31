package multi_threading.thread_state_monitoring_system;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class StateMonitor extends Thread {

    private Thread[] threads;
    private Map<String, Set<Thread.State>> stateHistory = new HashMap<>();

    public StateMonitor(Thread... threads) {
        this.threads = threads;
    }

    @Override
    public void run() {

        boolean monitoring = true;

        while (monitoring) {

            monitoring = false;

            for (Thread t : threads) {

                Thread.State state = t.getState();

                stateHistory.putIfAbsent(t.getName(), new HashSet<>());
                stateHistory.get(t.getName()).add(state);

                System.out.println("[Monitor] "
                        + t.getName()
                        + " is in "
                        + state
                        + " state at "
                        + LocalTime.now());

                if (state != Thread.State.TERMINATED) {
                    monitoring = true;
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Monitor interrupted.");
            }
        }

        System.out.println("\nSUMMARY");
        for (String name : stateHistory.keySet()) {
            System.out.println("Summary: "
                    + name
                    + " went through "
                    + stateHistory.get(name).size()
                    + " states -> "
                    + stateHistory.get(name));
        }
    }
}
