package multi_threading.print_shop_job_scheduler;

class PrintJob implements Runnable {

    private String jobName;
    private int pages;
    private int priority;

    public PrintJob(String jobName, int pages, int priority) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
    }

    private String getPriorityLabel() {
        if (priority >= 7) return "High Priority";
        else if (priority >= 5) return "Medium Priority";
        else return "Low Priority";
    }

    @Override
    public void run() {

        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= pages; i++) {
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                System.out.println(jobName + " interrupted.");
            }

            System.out.println("[" + getPriorityLabel() + "] Printing "
                    + jobName + " - Page " + i + " of " + pages);
        }

        long endTime = System.currentTimeMillis();

        System.out.println(jobName + " completed in "
                + (endTime - startTime) + "ms");
    }
}
